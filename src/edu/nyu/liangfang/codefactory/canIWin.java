package edu.nyu.liangfang.codefactory;

/*
 * boolean canIWin(int maxNum, int target)，从1,2...maxNum的数组里两个玩家轮流选数，第一个达到所有人选的数的sum>=target的玩家获胜，问如何判断先选的玩家能获胜。
 * 
 * canIWin(set{1..maxNum}, int target)先手必胜的条件是， 所有的 canIWin(set {1..MaxNum}中选出一个元素x， target - x) 状态中有1个状态先手会输（只要有一个就行了）.
 */
enum Result {
    Win, Lose, Draw
};

public class canIWin {
    public static Result canIWinCheck(int[] numberPool, int target) {
        if (target <= 0) return Result.Lose;
        boolean isEmpty = true;
        for (int data : numberPool)
            if (data > 0) isEmpty = false;
        if (isEmpty) return Result.Draw;
        else {
            for (int data : numberPool)
                if (data >= target) return Result.Win;

            // check if I choose any of remaining number will lead to opponent's fail
            Result drawFlag = Result.Draw;
            for (int i = 0; i < numberPool.length; ++i) {
                if (numberPool[i] > 0) {
                    int data = numberPool[i];
                    numberPool[i] = -1;
                    Result rivalResult = canIWinCheck(numberPool, target - data); // rival's turn.
                    if (rivalResult == Result.Win)
                        drawFlag = rivalResult;
                    if (rivalResult == Result.Lose)
                        return Result.Win;
                    numberPool[i] = data;
                }
            }
            if (drawFlag == Result.Draw) return Result.Draw;
            return Result.Lose; // whatever number i choose, rival wins
        }
    }
}
