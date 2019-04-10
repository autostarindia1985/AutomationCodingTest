package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
	
	 private static PropertyManager instance;
	    private static final Object lock = new Object();
	    private static String propertyFilePath = System.getProperty("user.dir")+
	            "\\src\\test\\resources\\configuration.properties";
	    private static String searchQuery;
	    private static String mobileNumber;
	    private static String exactLocation;
	    private static String restaurantName;
	    private static String name;
	    private static String password;
	    private static String email;
	    private static String chocoCake;
		private static String redCupCake;
		private static String tiramasuCake;
		private static String irishCake;

	    

	    //Create a Singleton instance. We need only one instance of Property Manager.
	    public static PropertyManager getInstance () {
	        if (instance == null) {
	            synchronized (lock) {
	                instance = new PropertyManager();
	                instance.loadData();
	            }
	        }
	        return instance;
	    }

		

	    private void loadData() {
	        //Declare a properties object
	        Properties prop = new Properties();

	        //Read configuration.properties file
	        try {
	            prop.load(new FileInputStream(propertyFilePath));
	        } catch (IOException e) {
	            System.out.println("Configuration properties file cannot be found");
	        }

	        //Get properties from configuration.properties
	        searchQuery = prop.getProperty("searchQuery");
	        mobileNumber = prop.getProperty("mobileNumber");
	        exactLocation = prop.getProperty("exactLocation");
	        restaurantName = prop.getProperty("restaurantName");
	        name = prop.getProperty("name");
	        password = prop.getProperty("password");
	        email = prop.getProperty("email");

	    }

	   

	    public String getsearchQuery () {
	        return searchQuery;
	    }

	    public String getmobileNumber () {
	        return mobileNumber;
	    }
	    
	    public String getPassword () {
	        return password;
	    }
	    
	    public String getexactLocation () {
	        return exactLocation;
	    }
	    
	    public String getName () {
	        return name;
	    }
	    
	    public String getEmail () {
	        return email;
	    }
	    	        
	    public String restaurantName () {
	        return restaurantName;
	    }
	    
	    public String ChocoCupcake () {
	        return chocoCake;
	    }
	    
	    public String RedCupcake () {
	        return redCupCake;
	    }
	    
	    public String Tiramasucake () {
	        return tiramasuCake;
	    }
	    
	    public String IrishCupcake () {
	        return irishCake;
	    }
	}



