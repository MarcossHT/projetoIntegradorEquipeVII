# Checkpoint Integrador - Sistema de reserva de consultas
## Integrantes Grupo 7
>_Ederson Oliveira_ - 
>_Jorge Silva_ - 
>_Marcelo Pacholak_ - 
>_Marcos Pires_ - 
>_Rodrigo Gottschall_
## Docente
>_Thiago Bellini_
## Mentoria
>_Giovanna Manfro_
## Disciplina: Back-end do Curso Certified Tech Developer by Digital House Brasil
## Atuação no projeto
Alinhado á realidade e curva de aprendizado de cada integrante, definimos no início do projeto que trabalharíamos nas mesas de forma colaborativa, porém, centralizando as aplicações do projeto em apenas um código(Marcos Pires).

Um dos motivos, foi evitar possíveis erros de commit, que integrantes mais experientes sinalizaram sobre essa possiblidade.

Dessa forma, a cada aula nós tinhamos a oportunidade de dar continuidade no que estivesse pendente e/ou aplicar os novos conteúdos passados em aula.

## Objetivo
>**Administração de dados odontológicos** - Adicionar e modificar os dados
dos dentistas. Registrar nome, sobrenome e matrícula de cadastro

>**Administração de pacientes** - Registrar, modificar e excluir pacientes. De
cada um se armazenam: nome, sobrenome, endereço, RG, data de alta

>**Login** - Validar a entrada no sistema por meio de um login com nome de
usuário e senha. Permitir que qualquer pessoa logada registre uma
consulta, mas apenas aqueles que têm uma função de administração pode
gerenciar dentistas e pacientes

>**Registrar consulta** - Deve ser possível permitir que um paciente seja
atribuído a uma consulta com um dentista em uma determinada data e
hora

### Aplicação
Criamos uma API para ser consumida por esse sistema, que, conectada á um banco de dados relacional, armazenará os dados dos pacientes, dentistas e consultas. E que contará com um sistema de login para a autenticação dos usuários.

A construção do sistema foi viabilizada através da criação dos itens abaixo:
- [X] Controllers
- [X] Repositories
- [X] Exceptions
- [X] Entities DTO
- [X] Services


### Tecnologias utilizadas
Java + SpringBoot via IntelliJ

H2 Database

Postman para validar toda a interação do sistema com o banco de dados, nos auxiliando á observar a administração da clínica, na prática.
