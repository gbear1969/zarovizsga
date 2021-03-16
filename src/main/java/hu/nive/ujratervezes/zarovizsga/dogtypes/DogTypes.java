package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DogTypes {
    private DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private List<String> selectDogsByPreparedStatement(PreparedStatement stmt) {
        List<String> result = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while(rs.next()) {
                result.add(rs.getString("name").toLowerCase());
            }
            return result;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot execute!", sqle);
        }
    }

    public List<String> getDogsByCountry(String country) {
        String countryByUpperCase = country.toUpperCase();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select name from dog_types where country =?")) {
            stmt.setString(1, countryByUpperCase);
            List<String> dogs = selectDogsByPreparedStatement(stmt);
            Collections.sort(dogs);
            return dogs;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Connection failed!", sqle);
        }

    }

}
