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

Conectividade: JDBC (Java Database Connectivity)

🔧 Configuração e Instalação
Pré-requisitos
JDK (Java Development Kit) instalado (versão 11 ou superior recomendada).

