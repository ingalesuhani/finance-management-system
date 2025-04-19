public static String getPropertyString(String filename) {
    Properties props = new Properties();
    props.load(new FileInputStream(filename));
    return "jdbc:mysql://" + props.getProperty("host") + ":" + props.getProperty("port") + "/" + 
           props.getProperty("dbname") + "?user=" + props.getProperty("username") + 
           "&password=" + props.getProperty("password");
}
