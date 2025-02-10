package com.gabrielle.Personal_Expenses.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.gabrielle.Personal_Expenses.dto.ExpenseIncomeDTO;

public class ExpenseIncomeModel extends AbstractTableModel {

    private final List<ExpenseIncomeDTO> entries;
    private final String[] columnName = {"Date", "Description", "Amount", "Type"};

    public ExpenseIncomeModel() {
        entries = new ArrayList<>();
    }

    public void addEntry(ExpenseIncomeDTO entry) {
        entries.add(entry);
        fireTableRowsInserted(entries.size()-1, entries.size()-1);
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

    @Override
    public int getColumnCount() { 
        return columnName.length;
    }
    @Override
    public int getRowCount() {
        return entries.size();
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ExpenseIncomeDTO entry = entries.get(rowIndex);

        switch (columnIndex) {
            case 0: return entry.getDate();
            case 1: return entry.getDescription();
            case 2: return entry.getAmount();
            case 3: return entry.getType();  
            default: return null;
        }
    }
}
