#ifndef ITERATOR_H
#define ITERATOR_H

using namespace std;

class Iterator{
    private: 
        unsigned int number = 0;

    public:
        Iterator(){}

        unsigned int Increment(){
            unsigned int previours = number;
            return number++;
        }

        unsigned int getNumber(){
            return number;
        }
        void setNumber(unsigned int Number){
            number = Number;
        }
};
#endif
