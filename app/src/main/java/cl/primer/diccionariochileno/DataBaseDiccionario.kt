package cl.primer.diccionariochileno

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*

@Entity(tableName = "palabra")
data class  Palabra (@PrimaryKey val id: Int, val name: String, val significado: String)


@Dao
        interface PalabrasDAO {
            @Insert(onConflict = OnConflictStrategy.REPLACE)
            suspend fun insertpalabra(palabraList: List<Palabra>)

            @Query("SELECT * FROM palabra")
            fun getPalabras(): LiveData<List<Palabra>>

        }

        @Database(entities=[Palabra::class], version=1)
        abstract class PalabrasDB: RoomDatabase() {
            abstract fun palabraDao(): PalabrasDAO
        }

        class PalabraApplication: Application() {
            companion object {
                var palabrasDatabase: PalabrasDB? = null
            }

            override fun onCreate(){
                super.onCreate()

                palabrasDatabase = Room
                    .databaseBuilder(this, PalabrasDB::class.java, "palabras_db")
                    .build()
            }
        }

