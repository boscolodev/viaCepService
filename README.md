Projeto Simples com Flyway, PostgreSQL e Feign Client

Este é um projeto simples que utiliza o Flyway para gerenciar as migrações do banco de dados PostgreSQL e o Feign Client para consumir a API do Via CEP.
Segundo a documentação do ViaCep é um serviço de busca de cep local e caso não encontre o CEP, realiza uma consulta na API ViaCep e salva os dados locais.
Projeto foi criado com intuito de ser utilizado em arquiteturas de microserviços que utilizem-se de cadastro de endereços, visando estudo de padrões de projeto como modelo hexagonal, e arquitetura limpa.
