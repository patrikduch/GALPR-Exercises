package galpr.rasterization;

import galpr.G_Color;
import galpr.G_Graphics;

import java.util.ArrayList;
import java.util.List;

import java.util.Arrays;

public class Square
{
    private int top;
    private int arr[][];//radek = x a y    sloupce = vrcholy
    private int hArray[][];//radek hrany a sloupce = ktere 2 body jsou spojene hranou

    public Square(int[] ints, int[] ints1)
    {
    }

    public Square(int arr[][], int hArr[][])
    {
        setArr(arr);
        sethArray(hArr);
    }

    public int getTop()
    {
        return top;
    }

    public void setTop(int top)
    {
        this.top = top;
    }

    public int[][] getArr()
    {
        return arr;
    }

    public void setArr(int[][] arr)
    {
        this.arr = arr;
    }

    public int getArrValue(int column, int row)
    {
        return arr[row][column];
    }

    public int getHArrValue(int column, int row)
    {
        return hArray[row][column];
    }

    public int[][] gethArray()
    {
        return hArray;
    }

    public void sethArray(int[][] hArray)
    {
        this.hArray = hArray;
    }

    @Override
    public String toString()
    {
        return "Square{" +
                "top=" + top +
                ", arr=" + Arrays.deepToString(arr) +
                ", hArray=" + Arrays.deepToString(hArray) +
                '}';
    }
}

/*hArr
0 1
1 2
2 3
3 0
 */

