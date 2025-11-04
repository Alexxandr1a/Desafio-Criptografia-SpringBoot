<h1>💻 Desafio de Criptografia — Java + Spring Boot</h1>

<p>
  Este projeto foi desenvolvido como solução para o desafio de criptografia proposto no repositório 
  <a href="https://github.com/backend-br/desafios/blob/master/cryptography/PROBLEM.md" target="_blank">Back-End Brasil 🚀</a>
</p>
<p>
  A aplicação foi construída com Spring Boot e implementa a criptografia de dados sensíveis (como tokens e documentos) antes de armazená-los no banco de dados.
</p>

<h3>🔐 Tecnologias utilizadas:</h3>
<p><li>Java 24</li>
<li>Spring Boot</li>
<li>JPA / Hibernate</li>
<li>H2 Database</li>
<li>Spring Web</li>
<li>Spring Security</li>
</p>

<p>
  O sistema expõe endpoints REST para criação e consulta de pagamentos, garantindo que as informações confidenciais sejam protegidas 
  através do uso de um conversor de criptografia personalizado (CryptoConverter).
</p>

<p>
  Utilizei o algoritimo de criptografia AES-GCM (AES-256-GCM), um algoritmo de criptografia simétrica. 
  Ele garante tanto a confidencialidade (os dados não podem ser lidos por pessoas não autorizadas) quanto a integridade (os dados não são alterados). 
</p>
