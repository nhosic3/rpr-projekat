package ba.unsa.etf.rpr;
import java.sql.*;
import java.util.*;

public class EmployeeDaoSQLImpl implements EmployeeDao{
    @Override
    public List<Employee> searchByText(String text) throws QuoteException{
        //mora sa concat jer inace nece raditi jer radi sa key chars
        String query = "SELECT * FROM quotes WHERE quote LIKE concat('%', ?, '%')";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setString(1, text);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Quote> quoteLista = new ArrayList<>();
            while (rs.next()) {
                quoteLista.add(row2object(rs));
            }
            return quoteLista;
        } catch (SQLException e) {
            throw new QuoteException(e.getMessage(), e);
        }
    }

    /**
     * @param category search string for quotes
     * @return list of quotes
     * @author ahajro2
     */
    @Override
    public List<Quote> searchByCategory(Category category) throws QuoteException{
        String query = "SELECT * FROM quotes WHERE category_id = ?";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setInt(1, category.getId());
            ResultSet rs = stmt.executeQuery();
            ArrayList<Quote> quoteLista = new ArrayList<>();
            while (rs.next()) {
                quoteLista.add(row2object(rs));
            }
            return quoteLista;
        } catch (SQLException e) {
            throw new QuoteException(e.getMessage(), e);
        }
    }
}
