<a href="https://www.java.com/"><img align="right" alt="Feito com Java" src="https://img.shields.io/badge/Feito%20com%20Java-orange?style=for-the-badge&logo=Java" /></a>

<h1 align="center">🌐 Make Response Interface 🌐</a></h1>
<p align="center">Biblioteca para consumo de API através de interfaces de modo fácil e rápido.</p>
<h4 align="center">🚧  Por enquanto em construção  🚧</h4>

----
<p align="center">
 <a href="#features">Features</a> • 
 <a href="#exemplos">Exemplos</a> • 
 <a href="#contribuição">Contribuição</a> • 
 <a href="#licença">Licença</a>
</p>
   
---

## Features

- [ ] Interface via Proxy.
- [ ] Interface via Compilação (em tempo de execução).
- [ ] Interface via Compilação (em tempo de compilação do projeto).
- [ ] Suporte assíncrono.

## Exemplos
```
@BaseURL("https://api.github.com/")
public interface GithubAPI {

    @Request("GET /users/{name}")![1f6a7](https://user-images.githubusercontent.com/12716747/143133532-8584110c-5a6d-4ccd-9677-b08ae5e527a1.png)

    GithubUser getUser(String name);

}

GithubAPI api = Factory.of(ProxiedFactory.class).make(GithubAPI.class);
```
   
## Contribuição
Solicitações pull são bem-vindas. Para mudanças importantes, abra um problema primeiro para discutir o que você gostaria de mudar. Certifique-se de atualizar os testes conforme apropriado

## Licença
Lançado sobre a licença MIT.