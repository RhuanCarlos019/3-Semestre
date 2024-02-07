#Exericio 1

a = 5
b = 6

soma = a + b
multiplicacao = a * b
divisao = a / b
divisao_inteira = a // b
resto = a % b
potencia = a ** b

print (soma, multiplicacao, divisao, divisao_inteira, resto, potencia)

# Calculando a área de um círculo
raio = 5
pi = 3.14
area = pi * (raio ** 2)
print("Área do círculo:", area)


# Exercicio 2

nome =  "Federico"
sobrenome = "Valverde"
nome_completo = nome + " " + sobrenome
print("Nome completo "+ nome_completo)


#Declarando a frase 
frase = "O Santos é o maior time do mundo"

#Convertendo para letra maiúscula
frase_maiuscula = frase.upper()
print("Frase em maiúsculo:"+ frase_maiuscula)

#Convertendo para letra minúscula
frase_minuscula = frase.lower()
print("Frase em minúsculo:"+ frase_minuscula)


#Exercicio 3

cores = ["verde", "azul", "amarelo", "laranja"]
print("Lista de cores inicial: " +cores)

#Adicionando outras cores a lista
cores.append = "preto"
cores.append = "Roxo"

# Declarando uma tupla com as coordenadas (latitude, longitude) de um local
coordenadas = (40.7128, -74.0060)

# Imprimindo cada valor separadamente
print("Latitude:", coordenadas[0])
print("Longitude:", coordenadas[1])


#Exercicio 4

tem_sol = True
tem_chuva = False

if tem_sol and not tem_chuva:
    print("É um dia agradável")
else:
    print("Não é um dia agradável")


# Verificação dos nº pares
numero1 = int(input("Digite o primeiro número: "))
numero2 = int(input("Digite o segundo número: "))

if numero1 % 2 == 0 and numero2 % 2 == 0:
    print("Ambos os números são pares.")
else:
    print("Pelo menos um dos números não é par.")

# Múltiplos de 3 e ímpares em uma lista
lista_numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

for numero in lista_numeros:
    if numero % 3 == 0 and numero % 2 != 0:
        print(numero, "é múltiplo de 3 e ímpar.")

# Verificação da idade
idade = int(input("Digite sua idade: "))

if idade >= 18 and idade <= 65:
    print("Você está dentro do intervalo de idade adequado para trabalhar.")
else:
    print("Você não está dentro do intervalo de idade adequado para trabalhar.")
