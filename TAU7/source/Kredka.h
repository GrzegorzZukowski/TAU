#ifndef KREDKA_H
#define KREDKA_H
#include <string>
#include <iostream>

using namespace std;

class Kredka{
    private:
        unsigned int id;
        string kolor;
        unsigned int dlugosc;

    public:
        Kredka(){}

        Kredka(string Kolor, unsigned int Dlugosc){
            setKolor(Kolor);
            setDlugosc(Dlugosc);
        }
        
        Kredka(unsigned int Id, string Kolor, unsigned int Dlugosc){
            setId(Id);
            setKolor(Kolor);
            setDlugosc(Dlugosc);
        }

    public:
        void setId(unsigned int Id){
            id= Id;
        }
        void setKolor(string Kolor){
            kolor= Kolor;
        }
        void setDlugosc(unsigned int Dlugosc){
            dlugosc = Dlugosc;
        }
        unsigned int getId(){
            return id;
        }
        string getKolor(){
            return kolor;
        }
        unsigned int getDlugosc(){
            return dlugosc;
        }
};
#endif
