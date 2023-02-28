public class ordenação{
    public static void main(String[] args) {
        
        int N = 10000;
        long init, end;
        
        //criando o vetor
        int vet[] = new int[N];

        //alimentando o vetor com valores aleatórios entre 0 e N*2
        for (int i = 0; i < N; i++) {
            vet[i] = (int) (Math.random()*(N*2));
        }

        //exibindo o vetor aleatório
        // System.out.println("Vetor original");
        // for (int i = 0; i < N; i++) {
        //     System.out.println(vet[i]);
        // }
        System.out.println("");
        
        //chamada ao método que ordena o vetor
        init = System.currentTimeMillis();
        ordenacao_simples(vet,N);
        end = System.currentTimeMillis();
        System.out.println("Tempo melhorado VERSÃO 1:" + (end - init)+ "ms");

        //exibindo o vetor ordenado
        // System.out.println("Vetor ORDENADO");
        // for (int i = 0; i < N; i++) {
        //     System.out.println(vet[i]);
        // }

        init = System.currentTimeMillis();
        new_ord(vet, N);
        end = System.currentTimeMillis();
        System.out.println("Tempo melhorado VERSÃO 2:" + (end - init)+ "ms");

        init = System.currentTimeMillis();
        new_version(vet, N);
        end = System.currentTimeMillis();
        System.out.println("Tempo melhorado VERSÃO 3:" + (end - init)+ "ms");

        init = System.currentTimeMillis();
        selection(vet, N);
        end = System.currentTimeMillis();
        System.out.println("Tempo melhorado VERSÃO 4:" + (end - init)+ "ms");

        init = System.currentTimeMillis();
        selection_with_troca(vet, N);
        end = System.currentTimeMillis();
        System.out.println("Tempo melhorado VERSÃO 5:" + (end - init)+ "ms");

    }

    private static void ordenacao_simples(int[] vet, int N) {
        for(int i=0; i<N; i++)
            for(int j=0; j<(N-1);j++)
                if(vet[j]>vet[j+1])
                    troca(vet,j,j+1);
        
    }

    private static void troca(int[] vet, int a, int b) {
        int temp = vet[a];
        vet[a] = vet[b];
        vet[b] = temp;
    }

    public static void new_ord(int [] vet, int N) {
        boolean flag = false;
        int i = 0;

        while (flag == false){
            int cont = N - 1 - i;

            for (int j = 0; j < (cont); j++){
                if(vet[j]> vet[j+1]){
                    troca(vet, j, j+1);
                }else if(j == (cont - 1)){
                    flag = true;
                }
            }
        }
        
        i++;
    }

    private static void new_version(int[] vet, int N) {
        boolean trocou = false;
        int i = 0;
        do{
            trocou = false;
            for (int j = 0; j < (N - 1 - i); j++) {
                if (vet[j] > vet[j + 1]) {
                    troca(vet, j, j + 1);
                    trocou = true;
                }
            }
            i++;
        }while(trocou);

    }

    public static void selection(int[] vet, int N){
        for (int fixo = 0; fixo < (N - 1); fixo++) {
            int menor = fixo;
            for (int i = menor + 1; i < N; i++) {
                if (vet[i] < vet[menor]) {
                    menor = i;
                }
            }
            if (menor != fixo) {
                int t = vet[fixo];
                vet[fixo] = vet[menor];
                vet[menor] = t;
            }
        }
    }

    public static void selection_with_troca(int[] vet, int N){
        for (int fixo = 0; fixo < (N - 1); fixo++) {
            int menor = fixo;
            for (int i = menor + 1; i < N; i++) {
                if (vet[i] < vet[menor]) {
                    menor = i;
                }
            }
            if (menor != fixo) {
                troca(vet, fixo, menor);
            }
        }
    }
}
