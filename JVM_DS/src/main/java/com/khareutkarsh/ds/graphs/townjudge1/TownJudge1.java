package com.khareutkarsh.ds.graphs.townjudge1;

import java.util.HashMap;
import java.util.Map;

/**
 * Leet code # 997
 */
public class TownJudge1 {
    public static void main(String[] args) {
        TownJudge1 obj = new TownJudge1();
        int trust[][] = {{1,2}};
        int n = 2;
        System.out.println("Naive Approach1 ->"+obj.findTownJudgeApproach1(n,trust));
        System.out.println("Naive Approach1 Efficient ->"+obj.findTownJudgeApproach1Eff(n,trust));
        System.out.println("Naive Approach2 Using Map ->"+obj.findTownJudgeApproach2Map(n,trust));
    }

    public int findTownJudgeApproach1(int n, int[][] trust) {
        int[] indeg = new int[n+1];
        int[] outdeg = new int[n+1];
        int minOutDegElem = 0;
        int maxInDegElem = 0;
        System.out.println(n+","+trust.length);
        for(int i=0;i<trust.length;i++)
        {
            indeg[trust[i][1]]++;
            outdeg[trust[i][0]]++;
        }

        for(int i=1;i<=n;i++)
        {
            if(indeg[i]==(n-1))
            {
                maxInDegElem = i;
                break;
            }
        }
        for(int i=1;i<=n;i++)
        {
            if(outdeg[i]==0)
            {
                minOutDegElem = i;
                break;
            }
        }
        if(maxInDegElem==minOutDegElem)
            return maxInDegElem;
        return -1;
    }

    public int findTownJudgeApproach1Eff(int n, int[][] trust) {
        int [] inOutDeg = new int[n+1];
            for(int i=0;i<trust.length;i++)
        {
            inOutDeg[trust[i][0]]--;
            inOutDeg[trust[i][1]]++;
        }

            for(int i=1;i<n+1;i++)
        {
            if(inOutDeg[i]==n-1)
                return i;
        }
            return -1;
    }

    public int findTownJudgeApproach2Map(int n, int[][] trust) {
        int townJudge = -1;
        Map<Integer,Integer> outDegMap = new HashMap<>();
        int[] inDegArr = new int[n+1];
        for(int i=0;i<trust.length;i++)
        {
            outDegMap.put(trust[i][0],outDegMap.getOrDefault(trust[i][0],0)+1);
            inDegArr[trust[i][1]]= inDegArr[trust[i][1]]+1;

        }

        for(int i=1;i<n+1;i++)
        {
            if(inDegArr[i]==n-1 && !outDegMap.containsKey(i))
            {
                townJudge = i;
                break;
            }
        }
        return townJudge;
    }

}
