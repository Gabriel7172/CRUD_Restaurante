# Conexão por JDBC - Passo a Passo

## Passo 1: CRIAÇÃO DO JAVA CLASS - ***"ConexãoDAO"***

## Passo 2: IMPORT DE BIBLIOTECAS NECESSÁRIAS

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

## Passo 2.1: IMPORT DE ***OPTIONPANE*** PARA MENSAGEM DE ERRO 

    import javax.swing.JOptionPane;

## Passo 3: CRIAÇÃO DA CLASSE DE CONEXÃO

    public Connection connectorDB() {
        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3306/BancoDeDados";
            String user = "root";
            String password = "";
            
            conn = DriverManager.getConnection(url, user, password); 
        } 
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro encontrado no arquivo 'ConnectorDAO': " + erro.getMessage());
        }

        return conn;
    }

## Passo 4: ADICIONAR DRIVER DE CONEXÃO

[SITE PARA DOWNLOAD DO DRIVER](https://dev.mysql.com/downloads/connector/j/)

Após o download: ***Libraries > Add JAR/Folder > Selecionar arquivo .jar (Driver)***



