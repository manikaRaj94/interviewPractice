package com.interviewpractice.machineCoding.splitwise.service;

import com.interviewpractice.machineCoding.splitwise.model.Split;
import com.interviewpractice.machineCoding.splitwise.model.User;

import java.util.List;
import java.util.Map;

public class SplitService {
    private List<User> userList ;
    private List<Split> expenseDetailList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Split> getExpenseDetailList() {
        return expenseDetailList;
    }

    public void setExpenseDetailList(List<Split> expenseDetailList) {
        this.expenseDetailList = expenseDetailList;
    }

    public  void addAmount(User paidUser, float amountPaid, int noOfUser, List<User> userList, String expenseShareEnum,
                                 Map<User,Integer> percentagePerUser)
    {

    }
 }
