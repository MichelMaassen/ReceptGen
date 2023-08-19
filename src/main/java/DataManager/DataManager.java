package DataManager;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;

public class DataManager {
    private static String ENDPOINT = "https://recepten17.blob.core.windows.net/";
    private static String SASTOKEN = "?sv=2022-11-02&ss=bfqt&srt=sco&sp=rwdlacupiytfx&se=2023-08-18T21:53:48Z&st=2023-08-18T13:53:48Z&spr=https&sig=Z3XjV%2BGebTtcXkr4BBdDTG7qi0R2%2B1S8V8rwVBzTX9k%3D";
    private static String CONTAINER = "receptcontainer";

    private static BlobContainerClient blobContainerClient = new BlobContainerClientBuilder().endpoint(ENDPOINT).sasToken(SASTOKEN).containerName(CONTAINER).buildClient();


}
