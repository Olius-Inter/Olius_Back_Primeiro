🛠️ Backend - Sistema de Gestão de Coletas e Sustentabilidade (Organização)
Este é o repositório do Backend da aplicação Organização, focado no gerenciamento de logística sustentável, coletas seletivas, Pontos de Entrega Voluntária (PEV), gestão de parceiros (B2B/B2C) e gamificação por meio do acúmulo e movimentação de pontos.

A aplicação foi desenvolvida em Java, utilizando o padrão de arquitetura DAO (Data Access Object) para separação de responsabilidades e manipulação direta da camada de dados.

📌 Principais Funcionalidades
Gestão de Usuários & Autenticação: Cadastro e controle de usuários, endereços e perfis.

Ecossistema B2B e B2C: Suporte para integração e gerenciamento de empresas parceiras (B2B) e consumidores/geradores (B2C).

Logística de Coleta & PEVs:

Solicitacao e agendamento de coletas.

Gestão de Pontos de Entrega Voluntária (PEV).

Controle de entregas em PEVs e atribuição de motoristas/rotas.

Eventos Sustentáveis: Criação de eventos de conscientização/mutirões e controle de participação de usuários.

Sistema de Pontuação & Recompensas (Gamificação):

Carteira digital do usuário.

Histórico e extrato de movimentação de pontos por ações sustentáveis.

Emissão de certificados de participação/impacto socioambiental.

🗂️ Estrutura do Projeto
A arquitetura do projeto segue o padrão MVC/DAO, organizada dentro do pacote principal Organização:

Plaintext
src/
└── Organização/
    ├── Conexao_Banco.java            # Gerenciamento da conexão com o banco de dados
    │
    ├── Model/                         # Mapeamento dos objetos / entidades de domínio
    │   ├── B2bModel.java
    │   ├── B2cModel.java
    │   ├── CarteiraModel.java
    │   ├── CertificadoModel.java
    │   ├── ColetaModel.java
    │   ├── EnderecoModel.java
    │   ├── EntregaPevModel.java
    │   ├── EventoModel.java
    │   ├── HistoricoModel.java
    │   ├── MotoristaModel.java
    │   ├── ParticipacaoEventoModel.java
    │   ├── PevModel.java
    │   ├── PontosMovimentacaoModel.java
    │   ├── PontuacaoModel.java
    │   ├── SolicitacaoColetaModel.java
    │   └── UsuarioModel.java
    │
    └── Dao/                           # Camada de persistência e operações SQL
        ├── B2bDAO.java
        ├── B2cDAO.java
        ├── CarteiraDAO.java
        ├── CertificadoDAO.java
        ├── ColetaDAO.java
        ├── EnderecoDAO.java
        ├── EntregaPevDAO.java
        ├── EventoDAO.java
        ├── HistoricoDAO.java
        ├── MotoristaDAO.java
        ├── ParticipacaoEventoDAO.java
        ├── PevDAO.java
        ├── PontosMovimentacaoDAO.java
        ├── PontuacaoDAO.java
        ├── SolicitacaoColetaDAO.java
        └── UsuarioDAO.java
🚀 Tecnologias Utilizadas
Linguagem: Java

Banco de Dados: Relacional (MySQL / PostgreSQL / Oracle / SQL Server)

Padrão de Projeto: DAO (Data Access Object) e DTO/Model

Conectividade: JDBC (Java Database Connectivity)

🔧 Configuração e Instalação
Pré-requisitos
JDK (Java Development Kit) instalado (versão 11 ou superior recomendada).

Driver JDBC do banco de dados utilizado adicionado ao classpath ou dependências do projeto.

Banco de Dados configurado e rodando.

Passos para execução:
Clonar o repositório:

Bash
git clone https://github.com/seu-usuario/seu-repositorio-backend.git
Configurar a Conexão com o Banco de Dados:
Abra a classe Organização/Conexao_Banco.java e ajuste as credenciais de acesso de acordo com o seu ambiente local:

Java
String url = "jdbc:seu_banco://localhost:3306/nome_do_banco";
String user = "seu_usuario";
String password = "sua_senha";
Compilar e Executar:
Abra o projeto na sua IDE de preferência (Eclipse, IntelliJ IDEA, NetBeans) ou compile via terminal:

Bash
javac -d bin src/Organização/*.java src/Organização/Model/*.java src/Organização/Dao/*.java
📝 Regras de Negócio e Modelo de Dados (Resumo)
Carteira & Pontuação:

Toda ação de entrega em PEV ou coleta realizada gera movimentação (PontosMovimentacaoModel) associada à carteira do usuário (CarteiraModel).

Coletas e Motoristas:

Uma SolicitacaoColetaModel pode ser transformada em uma ColetaModel e ser atribuída a um MotoristaModel.

PEV (Ponto de Entrega Voluntária):

Registra entregas feitas diretamente nos pontos autorizados através da classe EntregaPevDAO.

Certificados & Eventos:

A participação de usuários em eventos sustentáveis gera histórico e emissão de certificados comprovando o engajamento ecológico.
