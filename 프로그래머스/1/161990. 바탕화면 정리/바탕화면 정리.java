class Solution {
    public int[] solution(String[] wallpaper) {
        // int[] answer = {0,0,0,0};
        int startX = 51;
        int startY = 51;
        int endX = 0;
        int endY = 0;
        for(int y = 0; y<wallpaper.length; y++){
            String[] paper = wallpaper[y].split("");
            for(int x = 0; x<paper.length; x++){
                if(paper[x].equals("#")){
                    if(startX > x){ startX = x; }
                    if(startY > y){ startY = y; }
                    if(endX < x+1){ endX = x+1; }
                    if(endY < y+1){ endY = y+1; }
                }
            }
        }
    
        return new int[]{startY, startX, endY, endX};
    }
}