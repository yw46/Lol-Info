package com.fun.yishuo.lolinfo.Trash;

import com.fun.yishuo.lolinfo.R;

/**
 * Created by Yishuo Wang on 7/24/16.
 */
public class OldFunction {

    public static int getDrawableOld(String champ) {
        if (champ.charAt(0) == 'A') {
            if (champ.charAt(1) == 'a') {
                return R.drawable.champ_aatrox_square;
            } else if (champ.charAt(1) == 'h') {
                return R.drawable.champ_ahri_square;
            } else if (champ.charAt(1) == 'k') {
                return R.drawable.champ_akali_square;
            } else if (champ.charAt(1) == 'l') {
                return R.drawable.champ_alistar_square;
            } else if (champ.charAt(1) == 'm') {
                return R.drawable.champ_amumu_square;
            } else if (champ.charAt(1) == 'n') {
                if (champ.charAt(2) == 'i') {
                    return R.drawable.champ_anivia_square;
                } else if (champ.charAt(2) == 'n') {
                    return R.drawable.champ_annie_square;
                } else {
                    return R.drawable.champion_square;
                }
            } else if (champ.charAt(1) == 's') {
                return R.drawable.champ_ashe_square;
            } else if (champ.charAt(1) == 'u') {
                return R.drawable.champ_aurelionsol_square;
            } else if (champ.charAt(1) == 'z') {
                return R.drawable.champ_azir_square;
            }
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'B') {
            if (champ.charAt(1) == 'a') {
                return R.drawable.champ_bard_square;
            } else if (champ.charAt(1) == 'l') {
                return R.drawable.champ_blitzcrank_square;
            } else if (champ.charAt(1) == 'r') {
                if (champ.charAt(2) == 'a') {
                    if (champ.charAt(3) == 'n') {
                        return R.drawable.champ_brand_square;
                    } else if (champ.charAt(3) == 'u') {
                        return R.drawable.champ_braum_square;
                    } else {
                        return R.drawable.champion_square;
                    }
                } else {
                    return R.drawable.champion_square;
                }
            }
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'C') {
            if (champ.charAt(1) == 'a') {
                if (champ.charAt(2) == 'i') {
                    return R.drawable.champ_caitlyn_square;
                } else if (champ.charAt(2) == 's') {
                    return R.drawable.champ_cassiopeia_square;
                } else {
                    return R.drawable.champion_square;
                }
            } else if (champ.charAt(1) == 'h') {
                return R.drawable.champ_chogath_square;
            } else if (champ.charAt(1) == 'o') {
                return R.drawable.champ_corki_square;
            }
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'D') {
            if (champ.charAt(1) == 'a') {
                return R.drawable.champ_darius_square;
            } else if (champ.charAt(1) == 'i') {
                return R.drawable.champ_diana_square;
            } else if (champ.charAt(1) == 'r') {
                if (champ.charAt(2) == '.') {
                    return R.drawable.champ_drmundo_square;
                } else if (champ.charAt(2) == 'a') {
                    return R.drawable.champ_draven_square;
                } else {
                    return R.drawable.champion_square;
                }
            }
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'E') {
            if (champ.charAt(1) == 'k') {
                return R.drawable.champ_ekko_square;
            } else if (champ.charAt(1) == 'l') {
                return R.drawable.champ_elise_square;
            } else if (champ.charAt(1) == 'v') {
                return R.drawable.champ_evelynn_square;
            } else if (champ.charAt(1) == 'z') {
                return R.drawable.champ_ezreal_square;
            }
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'F') {
            if (champ.charAt(1) == 'i') {
                if (champ.charAt(2) == 'd') {
                    return R.drawable.champ_fiddlesticks_square;
                } else if (champ.charAt(2) == 'o') {
                    return R.drawable.champ_fiora_square;
                } else if (champ.charAt(2) == 'z') {
                    return R.drawable.champ_fizz_square;
                } else {
                    return R.drawable.champion_square;
                }
            }
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'G') {
            if (champ.charAt(1) == 'a') {
                if (champ.charAt(2) == 'l') {
                    return R.drawable.champ_galio_square;
                } else if (champ.charAt(2) == 'n') {
                    return R.drawable.champ_gangplank_square;
                } else if (champ.charAt(2) == 'r') {
                    return R.drawable.champ_garen_square;
                } else {
                    return R.drawable.champion_square;
                }
            } else if (champ.charAt(1) == 'n') {
                return R.drawable.champ_gnar_square;
            } else if (champ.charAt(1) == 'r') {
                if (champ.charAt(2) == 'a') {
                    if (champ.charAt(3) == 'g') {
                        return R.drawable.champ_gragas_square;
                    } else if (champ.charAt(3) == 'v') {
                        return R.drawable.champ_graves_square;
                    } else {
                        return R.drawable.champion_square;
                    }
                } else {
                    return R.drawable.champion_square;
                }
            }
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'H') {
            if (champ.charAt(1) == 'e') {
                if (champ.charAt(2) == 'c') {
                    return R.drawable.champ_hecarim_square;
                } else if (champ.charAt(2) == 'i') {
                    return R.drawable.champ_heimerdinger_square;
                } else {
                    return R.drawable.champion_square;
                }
            }
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'I') {
            if (champ.charAt(1) == 'l') {
                return R.drawable.champ_illaoi_square;
            } else if (champ.charAt(1) == 'r') {
                return R.drawable.champ_irelia_square;
            }
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'J') {
            if (champ.charAt(1) == 'a') {
                if (champ.charAt(2) == 'n') {
                    return R.drawable.champ_janna_square;
                } else if (champ.charAt(2) == 'r') {
                    return R.drawable.champ_jarvaniv_square;
                } else if (champ.charAt(2) == 'x') {
                    return R.drawable.champ_jax_square;
                } else if (champ.charAt(2) == 'y') {
                    return R.drawable.champ_jayce_square;
                } else {
                    return R.drawable.champion_square;
                }
            } else if (champ.charAt(1) == 'h') {
                return R.drawable.champ_jhin_square;
            } else if (champ.charAt(1) == 'i') {
                return R.drawable.champ_jinx_square;
            }
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'K') {
            if (champ.charAt(1) == 'a') {
                if (champ.charAt(2) == 'l') {
                    return R.drawable.champ_kalista_square;
                } else if (champ.charAt(2) == 'r') {
                    if (champ.charAt(3) == 'm') {
                        return R.drawable.champ_karma_square;
                    } else if (champ.charAt(3) == 't') {
                        return R.drawable.champ_karthus_square;
                    } else {
                        return R.drawable.champion_square;
                    }
                } else if (champ.charAt(2) == 's') {
                    return R.drawable.champ_kassadin_square;
                } else if (champ.charAt(2) == 't') {
                    return R.drawable.champ_katarina_square;
                } else if (champ.charAt(2) == 'y') {
                    return R.drawable.champ_kayle_square;
                } else {
                    return R.drawable.champion_square;
                }
            } else if (champ.charAt(1) == 'e') {
                return R.drawable.champ_kennen_square;
            } else if (champ.charAt(1) == 'h') {
                return R.drawable.champ_khazix_square;
            } else if (champ.charAt(1) == 'i') {
                return R.drawable.champ_kindred_square;
            } else if (champ.charAt(1) == 'o') {
                return R.drawable.champ_kogmaw_square;
            }
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'L') {
            if (champ.charAt(1) == 'e') {
                if (champ.charAt(2) == 'B') {
                    return R.drawable.champ_leblanc_square;
                } else if (champ.charAt(2) == 'e') {
                    return R.drawable.champ_leesin_square;
                } else if (champ.charAt(2) == 'o') {
                    return R.drawable.champ_leona_square;
                } else {
                    return R.drawable.champion_square;
                }
            } else if (champ.charAt(1) == 'i') {
                return R.drawable.champ_lissandra_square;
            } else if (champ.charAt(1) == 'u') {
                if (champ.charAt(2) == 'c') {
                    return R.drawable.champ_lucian_square;
                } else if (champ.charAt(2) == 'l') {
                    return R.drawable.champ_lulu_square;
                } else if (champ.charAt(2) == 'x') {
                    return R.drawable.champ_lux_square;
                } else {
                    return R.drawable.champion_square;
                }
            }
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'M') {
            if (champ.charAt(1) == 'a') {
                if (champ.charAt(2) == 'l') {
                    if (champ.charAt(3) == 'p') {
                        return R.drawable.champ_malphite_square;
                    } else if (champ.charAt(3) == 'z') {
                        return R.drawable.champ_malzahar_square;
                    } else {
                        return R.drawable.champion_square;
                    }
                } else if (champ.charAt(2) == 'o') {
                    return R.drawable.champ_maokai_square;
                } else if (champ.charAt(2) == 's') {
                    return R.drawable.champ_masteryi_square;
                }
                else {
                    return R.drawable.champion_square;
                }
            } else if (champ.charAt(1) == 'i') {
                return R.drawable.champ_missfortune_square;
            } else if (champ.charAt(1) == 'o') {
                if (champ.charAt(2) == 'r') {
                    if (champ.charAt(3) == 'd') {
                        return R.drawable.champ_mordekaiser_square;
                    } else if (champ.charAt(3) == 'g') {
                        return R.drawable.champ_morgana_square;
                    } else {
                        return R.drawable.champion_square;
                    }
                } else {
                    return R.drawable.champion_square;
                }
            }
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'N') {
            if (champ.charAt(1) == 'a') {
                if (champ.charAt(2) == 'm') {
                    return R.drawable.champ_nami_square;
                } else if (champ.charAt(2) == 's') {
                    return R.drawable.champ_nasus_square;
                } else if (champ.charAt(2) == 'u') {
                    return R.drawable.champ_nautilus_square;
                }
                else {
                    return R.drawable.champion_square;
                }
            } else if (champ.charAt(1) == 'i') {
                return R.drawable.champ_nidalee_square;
            } else if (champ.charAt(1) == 'o') {
                return R.drawable.champ_nocturne_square;
            } else if (champ.charAt(1) == 'u') {
                return R.drawable.champ_nunu_square;
            }
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'O') {
            if (champ.charAt(1) == 'l') {
                return R.drawable.champ_olaf_square;
            } else if (champ.charAt(1) == 'r') {
                return R.drawable.champ_orianna_square;
            }
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'P') {
            if (champ.charAt(1) == 'a') {
                return R.drawable.champ_pantheon_square;
            } else if (champ.charAt(1) == 'o') {
                return R.drawable.champ_poppy_square;
            }
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'Q') {
            if (champ.charAt(1) == 'u') {
                return R.drawable.champ_quinn_square;
            }
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'R') {
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'S') {
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'T') {
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'U') {
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'V') {
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'W') {
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'X') {
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'Y') {
            return R.drawable.champion_square;
        } else if (champ.charAt(0) == 'Z') {
            return R.drawable.champion_square;
        }
        return R.drawable.champion_square;
    }
}
