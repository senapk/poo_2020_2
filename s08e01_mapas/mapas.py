from typing import List, Dict


lista: List[int] = [5, 4, 3, 2, 1] # List
print(lista)
for v in lista:
    print(v)
print(lista[3]) # acesso aleatório

pessoas: Dict[str, int] = {} # Dict

# key=alex , valor=44
pessoas["david"] = 42
pessoas["camila"] = 41
pessoas["alex"] = 44
pessoas["bruno"] = 40

# valores
for valor in pessoas.values():
    print(valor, end=" ") # 44, 40, 41, 42
print("")
# chaves
for key in pessoas.keys():
    print(pessoas[key]) # get(key)
    print(valor, end=" ") #alex, bruno, camila, david
print("")

# tuplas
for key, valor in pessoas:
    print(key, valor)
