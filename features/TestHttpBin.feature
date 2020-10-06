# language: pt
# encoding: UTF-8

@TestHttpBin
Funcionalidade: Verificar Status Code da Api do Trello

  @GetExemplo
  Cenario: Verificar Get da Api do Trello
  	Dado que tenho url válida
  	E que tenho o endpoint de get do trello
    Quando realizo um get
    Então recebo o response
    E valido se o status code é 200
    