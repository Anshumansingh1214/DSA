class Solution {
        public boolean isMatch(String s, String p) {
                Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
                        return dp(0, 0, s, p, memo);
                            }

                                private boolean dp(int i, int j, String s, String p, Boolean[][] memo) {
                                        if (memo[i][j] != null) return memo[i][j];

                                                // If we reached end of pattern
                                                        if (j == p.length()) {
                                                                    return memo[i][j] = (i == s.length());
                                                                            }

                                                                                    // First match check: character match or '.'
                                                                                            boolean firstMatch = (i < s.length() &&
                                                                                                                          (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

                                                                                                                                  // Handle '*'
                                                                                                                                          if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                                                                                                                                                      // Two options:
                                                                                                                                                                  // 1. Skip "x*" (zero occurrence)
                                                                                                                                                                              // 2. Use "x*" if firstMatch is true
                                                                                                                                                                                          memo[i][j] = (dp(i, j + 2, s, p, memo) ||
                                                                                                                                                                                                                   (firstMatch && dp(i + 1, j, s, p, memo)));
                                                                                                                                                                                                                               return memo[i][j];
                                                                                                                                                                                                                                       } else {
                                                                                                                                                                                                                                                   // Normal character or '.' match
                                                                                                                                                                                                                                                               memo[i][j] = firstMatch && dp(i + 1, j + 1, s, p, memo);
                                                                                                                                                                                                                                                                           return memo[i][j];
                                                                                                                                                                                                                                                                                   }
                                                                                                                                                                                                                                                                                       }
                                                                                                                                                                                                                                                                                       }

