package cl.primer.diccionariochileno

import retrofit2.Response
import retrofit2.http.GET

interface DiccionarioApi {
        @GET("FRASES")
        suspend fun listapalabras(): Response<List<Palabra>>

}
