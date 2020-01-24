#define CATCH_CONFIG_MAIN
#include <catch2/catch.hpp>

#include "../source/Iterator.h"
#include "../source/Kredka.h"
#include "../source/DataBase.h"

TEST_CASE("operacje na iteratorze", "[Iterator][constructors]"){

    SECTION("mozna stworzyc iterator"){
        REQUIRE_NOTHROW([]() {Iterator iterator; });
    }
    SECTION("Metoda Increment()"){
        Iterator iterator;
        REQUIRE_NOTHROW(iterator.Increment());
    }
    SECTION("Iterator wykonuje swoje zadanie "){
        Iterator iterator;
        for(int i = 0; i<=5; i++){
            REQUIRE(iterator.Increment()==i);
        }
        REQUIRE(iterator.getNumber()==6);
    }
}

    TEST_CASE("operacje na encjach", "[Kredka][constructors]"){
        SECTION("Mozna stworzyc obiekt Kredka"){
            REQUIRE_NOTHROW([]() {Kredka kredka; });
        }

        SECTION("Mozna stworzyc Kredke ze wszystkimi argumentami"){
            REQUIRE_NOTHROW([]() {Kredka kredka(1, "szara", 25); });
        }

        SECTION("Mozna stworzyc Kredke z dwoma argumentami"){
            REQUIRE_NOTHROW([]() {Kredka kredka("szara", 25); });
        }

        SECTION("Dostęp do pól prywatnych przez gettery"){
            Kredka kredka(1, "szara", 25);
            REQUIRE(kredka.getId()==1);
            REQUIRE(kredka.getKolor()=="szara");
            REQUIRE(kredka.getDlugosc()==25);
        }

        SECTION("Ustawianie prywatnych pol poprzez settery"){
            Kredka kredka;
            kredka.setId(2);
            REQUIRE(kredka.getId()==2);
            kredka.setKolor("niebieska");
            REQUIRE(kredka.getKolor()=="niebieska");
            kredka.setDlugosc(11);
            REQUIRE(kredka.getDlugosc()==11);
        }
    }

TEST_CASE("Operacje na bazie danych", "[DataBase][constructors]"){
    SECTION("Utworzenie obiektu bazy danych"){
        REQUIRE_NOTHROW([]() {DataBase dataBase; });
    }

    SECTION("Dodanie do bazy"){
        DataBase dataBase;
        Kredka kredka(1, "szara", 25);
        REQUIRE_NOTHROW(dataBase.addKredka(kredka));
    }

    SECTION("Test dodania do bazy danych"){
        DataBase dataBase;
        Kredka kredka(1, "szara", 25);
        REQUIRE_NOTHROW(dataBase.addKredka(kredka));
        REQUIRE(dataBase.getAllKredki().size()==1);
    }

    SECTION("Pobierz wszystko"){
        DataBase dataBase;
        REQUIRE_NOTHROW(dataBase.getAllKredki());
    }

    SECTION("Test Pobierz wszystko"){
        Kredka kredka(1, "Szara", 25);
        Kredka kredka1(2, "czerwona", 11);
        DataBase dataBase;
        dataBase.addKredka(kredka);
        dataBase.addKredka(kredka1);
        REQUIRE(dataBase.getAllKredki().size()==2);
    }

    SECTION("Pobierz po id, zwaca błąd"){
        DataBase dataBase;
        REQUIRE_THROWS(dataBase.deleteKredkaById(1));
    }

    SECTION("Pobierz po id działa "){
        DataBase dataBase;
        Kredka kredka(1,"szara", 25);
        dataBase.addKredka(kredka);
        REQUIRE_NOTHROW(dataBase.getKredkaById(1).getId()==1);
    }

    SECTION("Pobierz po id rzuca wyjatek"){
        DataBase dataBase;
        Kredka kredka(1,"szara", 25);
        dataBase.addKredka(kredka);
        CHECK_THROWS(dataBase.getKredkaById(5));
        CHECK_THROWS_WITH(dataBase.getKredkaById(5), "Nie ma takiej kredki w bazie");
    }

    SECTION("Usun po id zwraca blad"){
        DataBase dataBase;
        REQUIRE_THROWS(dataBase.deleteKredkaById(1));
    }

    SECTION("Usun po id dziala poprawnie"){
        DataBase dataBase;
        Kredka kredka(1, "szara", 25);
        dataBase.addKredka(kredka);
        REQUIRE(dataBase.deleteKredkaById(1).getId()==0);
    }

    SECTION("Usun po id rzuca blad"){
        DataBase dataBase;
        Kredka kredka(1, "szara", 25);
        dataBase.addKredka(kredka);
        CHECK_THROWS(dataBase.deleteKredkaById(5));
        CHECK_THROWS_WITH(dataBase.deleteKredkaById(5), "Nie ma takiej kredki w bazie");
    }

    SECTION("GetKredkaByParameter rzuca bledem nie znaleziono takiej kredki"){
        DataBase dataBase;
        CHECK_THROWS(dataBase.getKredkaByParameter(1));
        CHECK_THROWS_WITH(dataBase.getKredkaByParameter(1), "nie znaleziono takiej kredki w bazie");
    }

    SECTION("GetKredkaByParameter rzuca bledem podaj jakis paraemtr"){
        DataBase dataBase;
        CHECK_THROWS_WITH(dataBase.getKredkaByParameter(), "podaj jakis parametr");
    }

    SECTION("GetKredkaByParameter znajduje kredke z trzema parametrami"){
        DataBase dataBase;
        Kredka kredka(1, "zielona", 25);
        Kredka kredka2(2,"brązowa", 23);
        dataBase.addKredka(kredka);
        dataBase.addKredka(kredka2);
        REQUIRE(dataBase.getKredkaByParameter(1,"zielona", 25).size()==1);
    }

    SECTION("GetKredkaByParameter znajduje kredke z dwoma parametrami"){
        DataBase dataBase;
        Kredka kredka(1, "zielona", 25);
        Kredka kredka2(2,"brązowa", 23);
        dataBase.addKredka(kredka);
        dataBase.addKredka(kredka2);
        REQUIRE(dataBase.getKredkaByParameter(2, "brązowa").size()==1);
    }

    SECTION("GetKredkaByParameter znajduje liste kredek po jednym parametrze"){
        DataBase dataBase;
        Kredka kredka(1, "zielona", 25);
        Kredka kredka2(2,"brązowa", 25);
        dataBase.addKredka(kredka);
        dataBase.addKredka(kredka2);
        REQUIRE(dataBase.getKredkaByParameter(-1,"null",25).size()==2);
    }
}
