class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int life = health;
        int heal = 0;
        int attackidx = 0;
        
        for(int i = 1; i <= attacks[attacks.length - 1][0]; i++){
            if(i != attacks[attackidx][0]){
                heal++;
                life += bandage[1];
                if(heal == bandage[0]) {
                    life += bandage[2];
                    heal = 0;
                }
                if(life >= health) life = health;
                System.out.println("life : " + life);
            } else {
                heal = 0;
                life -= attacks[attackidx][1];
                attackidx++;
                if(life <= 0) break;
                System.out.println("attack life : " + life);
            }
        }
        
        return life <= 0 ? -1 : life;
    }
}