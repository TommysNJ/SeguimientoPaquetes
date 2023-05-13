import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TrackingSystem {
    private List<Package> packages = new ArrayList<>();

    public void addPackage(Package pkg){
        packages.add(pkg);
    }
    public boolean removePackage(String trackingNumber){
        for (int i=0 ; i < packages.size() ; i++){
            if (packages.get(i).getTrackingNumber().equals(trackingNumber)) {
                packages.remove(packages.get(i));
                return true;
            }
        }
        return false;
    }

    public Package searchByRecipientAddress(String recipientAddress) {
        for (Package aPackage : packages) {
            if (aPackage.getRecipientAddress().toString().equals(recipientAddress)) {
                return aPackage;
            }
        }
        return null;
    }
    public Package searchByTrackingNumber(String trackingNumber){
        packages.sort(Comparator.comparing(Package::getTrackingNumber));

        // Buscar el paquete utilizando búsqueda binaria
        int inicio = 0;
        int tope = packages.size() - 1;
        while (inicio <= tope) {
            int medio = (inicio + tope) / 2;
            Package pkg = packages.get(medio);
            int comparison = pkg.getTrackingNumber().compareTo(trackingNumber);
            if (comparison == 0) {
                return pkg;
            } else if (comparison < 0) {
                inicio = medio + 1;
            } else {
                tope = medio - 1;
            }
        }
        return null;
    }
    public List<Package> searchByCity(String city){
        List<Package> ciudad = new ArrayList<>();
        for (Package aPackage : packages) {
            Address destinatario = aPackage.getRecipientAddress();
            if (destinatario.getCity().equalsIgnoreCase(city)) {
                ciudad.add(aPackage);
            }
        }
        return ciudad;
    }
}
