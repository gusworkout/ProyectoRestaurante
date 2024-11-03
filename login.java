// LLAMADA DEL CODIGO EN LA INTERFAZ PRINCIPAL USER


 /**
     * Creates new form Logina
     */
    public Logina() {
        initComponents();
        
        Conexion objetoConexion = new Conexion();
        objetoConexion.establecerConcexion();
    }
