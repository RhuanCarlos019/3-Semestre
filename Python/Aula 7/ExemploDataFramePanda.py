import matplotlib.pyplot as plt
import pandas as pd

data = {'Nome': ['Alice', 'Bruno', 'Carlos', 'Denis'],
        'Idade': [25, 28, 33, 35],
        'Cidade': ['A', 'B', 'C', 'D']}

df = pd.DataFrame(data)

# Acessando uma coluna por nome
coluna_idade = df['Idade']
print(coluna_idade)

# Selecionando linhas com base em uma condição
linha_filtro = df[df['Idade'] > 30]
print(linha_filtro)


# Adicionando uma nova coluna
df['Profissao'] = ['Engenheiro', 'Analista', 'Designer', 'Programador']
print(df)

# Removendo uma coluna
df_sem_cidade = df.drop('Cidade', axis=1)
print(df_sem_cidade)


# Gráfico de barras da idade por nome
df.plot.bar(x='Nome', y='Idade')
plt.show()