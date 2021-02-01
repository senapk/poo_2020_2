#include <stdio.h>
#include <stdbool.h> //bool

typedef struct{
    float value;
    bool sucesso;
} Result;

Result dividir(int a, int b){
    if(b == 0){
        return (Result){0, false};
    }
    return (Result){(float)a / b, true};
}

int main(){
    {
        Result result = dividir(4, 5);
        if(result.sucesso)
            printf("%f\n", result.value);
    }
    {
        Result result = dividir(4, 0);
        if(result.sucesso)
            printf("%f\n", result.value);
        else
            puts("divisao por zero");
    }
}