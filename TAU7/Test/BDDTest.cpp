#define CATCH_CONFIG_MAIN
#include <catch2/catch.hpp>

#include "../source/Iterator.h"
#include "../source/Kredka.h"
#include "../source/DataBase.h"

SCENARIO("Dodawanie, usuwanie, odnalezione po Id", "[DataBase]"){
    GIVEN("Wypełniamy bazę obiektami"){
        DataBase dataBase;
        REQUIRE_NOTHROW(dataBase.getId());
        Kredka kredka(1, "zielona", 25);
        Kredka kredka1(2,"niebieska",12);
        dataBase.addKredka(kredka);
        dataBase.addKredka(kredka1);
        REQUIRE(dataBase.getAllKredki().size()==2);

        WHEN("Próba usunięcia pomyślna"){
            THEN("liczba rekordów zmniejsza się do 1"){
                dataBase.deleteKredkaById(2);
                CHECK(dataBase.getAllKredki().size()==1);
            }
        }

        WHEN("Usunięcie nieudane"){
            THEN("wyrzuca błąd"){
                CHECK_THROWS(dataBase.deleteKredkaById(15));
                CHECK_THROWS_WITH(dataBase.deleteKredkaById(15), "Nie ma takiej kredki w bazie");
            }
        }

        WHEN("Dodaje kredke do bazy"){
            Kredka kredka2(3, "czerwona",23);
            dataBase.addKredka(kredka2);
            THEN("to zwieksza sie liczba rekordów"){
                REQUIRE(dataBase.getAllKredki().size()==2);
            }
        }

        WHEN("Wyszukuję kredkę po id"){
            THEN("znajduje kredkę jaka mnie interesuje"){
                REQUIRE(dataBase.getKredkaById(1).getKolor()=="zielona");
                CHECK(dataBase.getKredkaById(1).getId()==1);
            }
        }

        WHEN("Wyszukuję kredkę po id"){
            THEN("nie udaje mi się jej znaleźć"){
                CHECK_THROWS(dataBase.getKredkaById(15));
                CHECK_THROWS_WITH(dataBase.getKredkaById(15), "Nie ma takiej kredki w bazie");
            }
        }

        WHEN("Wyszukuje po parametrze i znajduje dwie kredki"){
            Kredka kredka3(4,"pomaranczowa", 12);
            Kredka kredka4(5, "zielona", 12);
            dataBase.addKredka(kredka3);
            dataBase.addKredka(kredka4);
            THEN("Liczba kredek w znalezionej liscie wynosi 2"){
                CHECK(dataBase.getKredkaByParameter(-1,"null",12).size()==2);
                CHECK_NOTHROW(dataBase.getKredkaByParameter(-1,"null",12));
            }
        }

        WHEN("Wyszukuje po parametrze i nie znajduje kredki"){
            THEN("Rzuca błąd "){
                CHECK_THROWS(dataBase.getKredkaByParameter());
                CHECK_THROWS_WITH(dataBase.getKredkaByParameter(), "Podaj jakis parametr");
            }
        }

    }
}
