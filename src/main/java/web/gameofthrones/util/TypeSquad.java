package web.gameofthrones.util;

import com.sun.org.apache.xpath.internal.operations.Equals;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
public enum TypeSquad {

    SPEARMAN("Копейщики", 2, 2),
    ARCHER("Лучники", 3, 4),
    CAVALRY("Конница", 5, 6);

    private String typeName;
    private int costs;
    private int forcePerPerson;

    TypeSquad(String typeName, int costs, int forcePerPerson){
        this.costs = costs;
        this.typeName = typeName;
        this.forcePerPerson = forcePerPerson;
    }

    public static int getCosts(String typeName){
        try {
            return TypeSquad.getTypeSquad(typeName).getCosts();
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public static int getForcePerPerson(String typeName){
        try {
            return TypeSquad.getTypeSquad(typeName).getForcePerPerson();
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public static TypeSquad getTypeSquad(String typeName) throws Exception {
        return Arrays.stream(TypeSquad.values()).filter(v -> v.getTypeName().equals(typeName)).findFirst().orElseThrow(()-> new Exception(String.format("Unknown Type")));
    }

}
