public class Patterns {
    public void A(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void B(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public void C(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void D(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(j + 1 + " ");
            }
            System.out.println();
        }
    }

    public void E(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int k = (i + j) % 2 == 1 ? 0 : 1;
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }

    public void F(int n) {
        int c = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(c + " ");
                c++;
            }
            System.out.println();
        }
    }

    public void G(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void J(int n) {
        for (int i = 1; i <= (n * 2) - 1; i++) {
            int rowChage = i > n ? (n * 2) - i : i;
            for (int j = 1; j <= rowChage; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void K(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n - i); j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void L(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= (n - (i - 1)); j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void M(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n - i); j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= (i * 2) - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    public void Q(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n - i); j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= (i * 2) - 1; j++) {
                if (j == 1 || j == (i * 2) - 1 || i == n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }

    public void V(int n) {
        for (int i = 1; i <= n * 2; i++) {
            int rowChange = i > n ? (n * 2) - (i - 1) : i;

            for (int j = 1; j <= n * 2; j++) {
                if (j <= n - rowChange + 1 || j > n + rowChange - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }

    public void Z(int n) {
        for (int i = 1; i <= (n * 2) - 1; i++) {

            for (int j = 1; j <= (n * 2) - 1; j++) {
                int topd = i, downd = (n * 2) - i, leftd = j, rightd = (n * 2) - j;
                int mins = Math.min(Math.min(topd, downd), Math.min(leftd, rightd));
                System.out.print(mins + " ");
                // System.out.print(n - (mins) + 1 + " ");

            }
            System.out.println();
        }

    }

}
