package cl.primer.diccionariochileno

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private const val BASE_URL = "http://my-json-server.typicode.com/yoyocataldo/Diccionariochileno/"

        suspend fun instance(): DiccionarioApi {
            val retrofit = Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(DiccionarioApi::class.java)


        }
    }
}