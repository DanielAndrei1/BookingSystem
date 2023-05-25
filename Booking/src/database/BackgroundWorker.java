package database;

import encryption.EncryptionUtil;
import encryption.EncryptionUtil.EncryptedData;

public class BackgroundWorker {
    private Database database;

    public BackgroundWorker(Database database) {
        this.database = database;
    }

    public void doInBackground(String... params) {
        String typeOfStatementString = params[0];

        if (typeOfStatementString.equals("Read")) {
            String User_ID = params[1];
            String Pass = params[2];
            // Encrypt
            EncryptedData encryptedDataPass = EncryptionUtil.encrypt(Pass);
            System.out.println("User-ID:" + User_ID);
            System.out.println("Pass:" + Pass);
            System.out.println("Pass: encrypted IV" + encryptedDataPass.getInitializationVector());
            System.out.println("Pass: encrypted Ev" + encryptedDataPass.getEncryptedValue());
            database.databaseRead(User_ID, encryptedDataPass);
        } else if (typeOfStatementString.equals("Insert")) {
            String User_ID = params[1];
            String Pass = params[2];
            String First_Name = params[3];
            String Surname = params[4];
            String Mobile_No = params[5];
            String Email = params[6];
            String Cabin_no = params[7];
            String Admin = params[8];
            
            // Encrypt
            EncryptedData encryptedDataPass = EncryptionUtil.encrypt(Pass);
            EncryptedData encryptedDataFN = EncryptionUtil.encrypt(First_Name);
            EncryptedData encryptedDataSN = EncryptionUtil.encrypt(Surname);
            EncryptedData encryptedDataCabin = EncryptionUtil.encrypt(Cabin_no);
            EncryptedData encryptedDataMobile = EncryptionUtil.encrypt(Mobile_No);
            EncryptedData encryptedDataEmail = EncryptionUtil.encrypt(Email);
               
            // Store the encrypted values directly in the database
            database.insertData(User_ID, encryptedDataPass, encryptedDataFN, encryptedDataSN, encryptedDataMobile, encryptedDataEmail, encryptedDataCabin, Admin);
        }
    }

}

