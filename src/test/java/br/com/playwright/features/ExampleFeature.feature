#language: pt
Funcionalidade: Example Funcionalidade
Contexto:
  Dado que eu estou no site camicado

Cenário: Validar PDP
  Quando pesquiso por "Quadro Decorativo para Camiseta de Futebol"
  Então vejo a lista de resultados
  Quando clico no resultado com texto "Quadro Decorativo para Camiseta de Futebol, Esportes Preto"
  Então vejo a página do produto