/**
 * Created by phandung on 5/22/17.
 */
public class HaNoiTower {

    public static void main(String[] args) {
        doHaNoiTower( 4, 'F','M','D');
    }

    private static void doHaNoiTower(int disks , char rodFrom , char rodMiddel , char rodTo){

        if(disks == 1){
            System.out.println(" Plate 1 from "  +rodFrom+  " to -->  " +rodTo);
            return;
        }
        System.out.println(" Starting with n=" +disks);
        doHaNoiTower(disks -1,rodFrom,  rodTo  , rodMiddel);
        System.out.println(" Move --> "+ disks+" from  "  +rodFrom+  " to -->  " +rodTo);
        doHaNoiTower(disks-1,rodMiddel, rodFrom, rodTo);
    }

}
