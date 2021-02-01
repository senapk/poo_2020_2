#include <iostream>
using namespace std;

float dividir(int a, int b){
    if(a == 13)
        throw 13;
    if(b == 0)
        throw invalid_argument("deu ruim no b, b veio 0");
    return (float) a / b;
}
float maior_resultado(int a, int b, int c, int d){
    float x, y;
    try{
        x = dividir(a, b);
        y = dividir(c, d);
    }catch(int value){
        x = dividir(2 * a, 2 * b);
        y = dividir(2 * c, 2 * d);
    }
    if(y == x)
        throw string("fail: valores iguais");
    return x > y ? x : y; // std::max(x, y);
}
int main(){
    int a, b, c, d;
    cout << "Digite 4 inteiros: ";
    cin >> a >> b >> c >> d;
    try{
        float result = maior_resultado(a, b, c, d);
        cout << result << endl;
    }catch(string s){
        cout << "string: " <<  s << endl;
    }catch(invalid_argument e){
        cout << "iarg: " << e.what() << endl;
    }
}