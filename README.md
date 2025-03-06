# Backend - Personal Expenses

## Conceito
A aplicação tem como objetivo organizar as despesas pessoais do usuário. Ela conta com funcionalidades como cadastro e login, visualizar o histórico das despesas e registro de novos gastos.

## Organização

### Pastas

#### `authentication/`
Responsável pela autenticação do usuário, armazenando suas principais informações. Utiliza uma coleção para verificar o tipo de usuário (user ou admin).

Exemplo:
```java
public Collection<? extends GrantedAuthority> getAuthorities() {  
    if (this.role == UserRole.ADMIN)  
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));  
    else  
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));  
}
```

##### Tipos de Usuário

- **User**: Possui acesso limitado aos recursos, seguindo a lógica de uma “versão grátis” comum na indústria.
- **Admin**: Representa a “versão paga”, contendo todos os benefícios do User, além de funcionalidades adicionais.

#### `config/`
Gerencia as configurações da aplicação.

- **SecurityConfiguration**: Define a segurança no acesso dos usuários, desativando o padrão do Spring Security e implementando a lógica das rotas de login e registro. Define quais endpoints exigem autenticação ou a inclusão de novas informações para registrar um usuário.
- **SecurityFilter**: Verifica se o usuário forneceu um token válido na área de login. Caso o token seja `null` ou inválido, o sistema retorna um erro.

#### `controller/`
Contém as rotas **POST** (`/login` e `/register`) e as verificações necessárias, como a validade do token e a criptografia da senha.

#### `dto/`
Armazena os **records** usados no registro, login e autenticação, contendo os parâmetros necessários para cada funcionalidade.

Exemplo:
```java
public record AuthenticationDTO(String login, String password) {}
```

#### `repository/`
Interface que estende `JpaRepository`, facilitando a interação com o banco de dados. Utiliza `User` e `String` (referente à senha) como parâmetros e retorna o login.

#### `service/`
Responsável pelos serviços oferecidos ao sistema.

- **AuthorizationService**: Chama o repositório e verifica as credenciais do usuário, buscando no banco de dados um usuário com o login informado para garantir que ele existe.
- **TokenService**: Gera um token, criptografa-o com um hash, valida sua autenticidade e define um tempo de expiração de 2 horas.

#### `PersonalExpensesApplication/`
Arquivo principal responsável pela inicialização da aplicação.

---

## Branches

- **`backend/`**: Utilizado para criação das funcionalidades de login e registro.
- **`feature/expenseIncome`**: Foca no cadastro das despesas e da renda do usuário.
- **`database/`**: Concentra-se na integração com o Docker e o banco de dados selecionado, no caso, o PostgreSQL.
- **`main/`**: Branch principal utilizada para conectar todas as outras após devidos tratamentos, focando na aplicação completa.
- **`conexion-frontend`**: Foca em conectar o backend a outro repositório com foco no frontend.

## Descrição das Funcionalidades

### Cadastrar
Permite que novos usuários realizem o cadastro na aplicação para acessar as funcionalidades do sistema.

### Login
Usuários cadastrados podem acessar suas contas por meio do login.

### Visualizar Histórico
Exibe todas as despesas previamente registradas pelo usuário, permitindo um acompanhamento detalhado dos gastos.

### Registrar Despesa
Funcionalidade responsável por adicionar novas despesas ao sistema, garantindo um controle financeiro eficiente.

### Adicionar Metas
Permite que o usuário defina objetivos financeiros a serem alcançados, auxiliando no planejamento das despesas.

### Editar Despesas (CRUD)
Além de cadastrar despesas, o usuário pode editar, excluir ou atualizar registros existentes, garantindo maior flexibilidade no gerenciamento financeiro.

---

## Database - Integração com Docker e PostgreSQL
A aplicação utiliza **PostgreSQL** como banco de dados, integrando-o ao **Docker** para facilitar a configuração e a execução da aplicação em diferentes sistemas operacionais. O uso do Docker permite que os desenvolvedores configurem rapidamente o ambiente e colaborem na evolução da aplicação sem complicações.

### Arquivos principais da conexão com o banco de dados

#### 1. `application.properties`
- Contém as credenciais e configurações do banco de dados.
- Armazena o token gerado no login da aplicação.
- Pode utilizar **variáveis de ambiente** para proteger informações sensíveis, evitando que senhas fiquem expostas no código.

#### 2. `docker-compose.yml`
- Define os serviços necessários para rodar a aplicação, incluindo o **PostgreSQL** e o **Java**.
- Configura **portas, credenciais e volumes** para garantir persistência dos dados.
- Permite subir os containers com um único comando:  
  ```bash
  docker-compose up
  ```

#### 3. `Dockerfile`
- Define como a aplicação será empacotada e executada dentro do container.
- Copia a versão correta do **Java** utilizada pelo Maven.
- Expõe a porta da aplicação e define qual **JAR** será executado.

#### 4. `.env-example`
- Modelo do arquivo `.env` que contém as variáveis de ambiente utilizadas na aplicação.
- Inclui instruções sobre como configurar a senha do banco de dados e outras credenciais de forma segura.
```

