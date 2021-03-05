package com.interview.eventtask

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.interview.eventtask.`interface`.CellClickListener
import com.interview.eventtask.adapter.TestAdapter
import com.interview.eventtask.model.EventTaskModel
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity(), CellClickListener {

    private lateinit var adapter: TestAdapter
    private lateinit var recyclerView: RecyclerView
    val client = OkHttpClient()
    var arrayList_details:ArrayList<EventTaskModel> = ArrayList();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        run("https://app.ticketmaster.com/discovery/v2/events.json?apikey=PeGhsWyOKSpmgAqy5rPw1aC3UFtcjNhE")

        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    fun run(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                Toast.makeText(this@MainActivity, "${e.message}", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: okhttp3.Call, response: Response) {
                val str_response = response.body!!.string()
                val json_contact:JSONObject = JSONObject(str_response)
                val jsonarray_info: JSONObject = json_contact.getJSONObject("_embedded")
                val jsonarray_event:JSONArray= jsonarray_info.getJSONArray("events")
                var i:Int = 0
                val size:Int = jsonarray_event.length()
                arrayList_details= ArrayList();
                for (i in 0.. size-1) {
                    val json_objectdetail:JSONObject=jsonarray_event.getJSONObject(i)
                    val model:EventTaskModel= EventTaskModel();
                    model.id=json_objectdetail.getString("id")
                    model.name=json_objectdetail.getString("name")

                    val json_dates: JSONObject = jsonarray_event.getJSONObject(i).getJSONObject("dates")
                    val json_start: JSONObject = json_dates.getJSONObject("start")
                    model.localDate=json_start.getString("localDate")
                    model.localTime=json_start.getString("localTime")

                    if(json_objectdetail.has("info")){
                        model.info=json_objectdetail.getString("info");
                    }

                    json_objectdetail.getString("info")?.let {
                       model.info=json_objectdetail.getString("info")
                  }

                    val json_embedded: JSONObject = jsonarray_event.getJSONObject(i).getJSONObject("_embedded")
                    val jsonarray_venues:JSONArray= json_embedded.getJSONArray("venues")
                    var j:Int = 0
                    val venueSize:Int = jsonarray_venues.length()
                    for (j in 0.. venueSize-1) {
                        val json_venues_detail:JSONObject=jsonarray_venues.getJSONObject(j)
                        val json_city: JSONObject = json_venues_detail.getJSONObject("city")
                        model.city=json_city.getString("name")

                        val json_state: JSONObject = json_venues_detail.getJSONObject("state")
                        model.state=json_state.getString("name")

                        val json_country: JSONObject = json_venues_detail.getJSONObject("country")
                        model.country=json_country.getString("name")

                        val json_location: JSONObject = json_venues_detail.getJSONObject("location")
                        model.latitude=json_location.getString("latitude")
                        model.longitude=json_location.getString("longitude")
                    }
                    arrayList_details.add(model)
                }
                runOnUiThread {
                    adapter = TestAdapter(this@MainActivity,arrayList_details,this@MainActivity);
                    recyclerView.adapter=adapter
                }
            }
        })
    }

    override fun onCellClickListener(data: EventTaskModel) {
        val intent = Intent(this@MainActivity,MapsActivity::class.java)
        intent.putExtra("Name",data.name)
        intent.putExtra("City",data.city)
        intent.putExtra("State",data.state)
        intent.putExtra("Country",data.country)
        intent.putExtra("Latitude",data.latitude)
        intent.putExtra("Longitude",data.longitude)
        startActivity(intent)
    }
}