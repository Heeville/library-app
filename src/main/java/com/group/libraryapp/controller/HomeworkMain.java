package com.group.libraryapp.controller;
import java.util.Scanner;


public class HomeworkMain {
    private static int DICE_SIZE=6; //주사위 면의 수
    private static int[] elementDice=new int[DICE_SIZE]; //각 요소별 나온 횟수를 저장하는 배열


    //메인함수(실행함수)
    public static void main(String[] args) throws Exception {
        inputNum();
        printDice();
    }
    // 숫자를 입력하는 함수
    public static void inputNum(){
        System.out.print("숫자를 입력하세요: ");
        Scanner scanner=new Scanner(System.in);
        int input=scanner.nextInt();
        calculateDice(input);
    }
    // 주사위 각 면이 얼만큼 나왔는 지 계산하는 함수
    public static void calculateDice(int input){
        for(int i=0; i<input; i++){
            int number=(int)(Math.random()*DICE_SIZE)%DICE_SIZE;
            elementDice[number]++;
        }

    }
    // 주사위 각 면의 얼만큼 나왔는 지 출력하는 함수
    public static void printDice(){
        for(int i=0; i<DICE_SIZE; i++){
            System.out.println((i+1)+"번은 "+elementDice[i]+"번 나왔습니다.");
        }
    }
}
