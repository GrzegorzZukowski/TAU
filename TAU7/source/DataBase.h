#ifndef DATABASE_H
#define DATABASE_H
#include "Kredka.h"
#include "Iterator.h"
#include <string>
#include <list>

using namespace std;

class DataBase{
    private:
        Iterator iterator;
        list<Kredka> listaKredek;

    public:
        DataBase(){
            setId(0);
        }

        void setId(unsigned int Id){
            iterator.setNumber(Id);
        }
        unsigned int getId(){
            return iterator.getNumber();
        }


        list<Kredka> getAllKredki(){
            return listaKredek;
        }

        Kredka getKredkaById(unsigned int id){
            std::list<Kredka>::iterator it = listaKredek.begin();
            for(it; it!= listaKredek.end(); ++it){
                if(it->getId()==id){
                    return *it;
                }
            }
            throw "Nie ma takiej kredki w bazie";
        }

        void addKredka(Kredka kredka){
            kredka.setId(iterator.Increment());
            setId(iterator.getNumber());
            listaKredek.push_back(kredka);
        }

        Kredka deleteKredkaById(unsigned int id){
            Kredka kredkaDoUsuniecia;
            std::list<Kredka>::iterator it = listaKredek.begin();
            for(it; it!=listaKredek.end(); ++it){
                if(it->getId()== id){
                    kredkaDoUsuniecia=*it;
                    listaKredek.erase(it);
                    return kredkaDoUsuniecia;
                }
            }
            throw "Nie ma takiej kredki w bazie";
        }

        list<Kredka>getKredkaByParameter(unsigned int id = -1, string kolor = "null", unsigned int dlugosc = -1){
            list<Kredka> znalezioneKredki;

            if(id==-1 && kolor=="null" && dlugosc ==-1){
                throw "podaj jakis parametr";
            }
            else{
                std::list<Kredka>::iterator it = listaKredek.begin();
                for(it; it!=listaKredek.end(); ++it){
                    if(id != -1 || kolor != "null" || dlugosc != -1){
                        znalezioneKredki.push_back(*it);
                    }
                }
            }
            if(znalezioneKredki.size()>0){
                return znalezioneKredki;
            }
            else{
                throw "nie znaleziono takiej kredki w bazie";
            }
        }
};
#endif
