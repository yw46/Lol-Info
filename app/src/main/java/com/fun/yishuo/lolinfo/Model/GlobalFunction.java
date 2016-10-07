package com.fun.yishuo.lolinfo.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;

import com.fun.yishuo.lolinfo.R;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Yishuo Wang on 7/23/16.
 */
public class GlobalFunction {

    public static final int DB_VERSION = 3;
    public static int getDrawable(String champ) {
        int i = champ.length();
        char c0, c1, c2, c3;
        c0 = champ.charAt(0);
        c1 = champ.charAt(1);
        c2 = 'z';
        c3 = 'z';
        if (i == 3) {
            c2 = champ.charAt(2);
            c3 = 'z';
        } else if (i >= 4) {
            c2 = champ.charAt(2);
            c3 = champ.charAt(3);
        }

        //TODO get R.drawable.<champion>
        if (c0 == 'A') {
            if (c1 == 'a') {
                return R.drawable.champ_aatrox_square;
            } else if (c1 == 'h') {
                return R.drawable.champ_ahri_square;
            } else if (c1 == 'k') {
                return R.drawable.champ_akali_square;
            } else if (c1 == 'l') {
                return R.drawable.champ_alistar_square;
            } else if (c1 == 'm') {
                return R.drawable.champ_amumu_square;
            } else if (c1 == 'n') {
                if (c2 == 'i') {
                    return R.drawable.champ_anivia_square;
                } else if (c2 == 'n') {
                    return R.drawable.champ_annie_square;
                } else {
                    return R.drawable.champion_square;
                }
            } else if (c1 == 's') {
                return R.drawable.champ_ashe_square;
            } else if (c1 == 'u') {
                return R.drawable.champ_aurelionsol_square;
            } else if (c1 == 'z') {
                return R.drawable.champ_azir_square;
            }
            return R.drawable.champion_square;
        } else if (c0 == 'B') {
            if (c1 == 'a') {
                return R.drawable.champ_bard_square;
            } else if (c1 == 'l') {
                return R.drawable.champ_blitzcrank_square;
            } else if (c1 == 'r') {
                if (c2 == 'a') {
                    if (c3 == 'n') {
                        return R.drawable.champ_brand_square;
                    } else if (c3 == 'u') {
                        return R.drawable.champ_braum_square;
                    } else {
                        return R.drawable.champion_square;
                    }
                } else {
                    return R.drawable.champion_square;
                }
            }
            return R.drawable.champion_square;
        } else if (c0 == 'C') {
            if (c1 == 'a') {
                if (c2 == 'i') {
                    return R.drawable.champ_caitlyn_square;
                } else if (c2 == 's') {
                    return R.drawable.champ_cassiopeia_square;
                } else {
                    return R.drawable.champion_square;
                }
            } else if (c1 == 'h') {
                return R.drawable.champ_chogath_square;
            } else if (c1 == 'o') {
                return R.drawable.champ_corki_square;
            }
            return R.drawable.champion_square;
        } else if (c0 == 'D') {
            if (c1 == 'a') {
                return R.drawable.champ_darius_square;
            } else if (c1 == 'i') {
                return R.drawable.champ_diana_square;
            } else if (c1 == 'r') {
                if (c2 == '.') {
                    return R.drawable.champ_drmundo_square;
                } else if (c2 == 'a') {
                    return R.drawable.champ_draven_square;
                } else {
                    return R.drawable.champion_square;
                }
            }
            return R.drawable.champion_square;
        } else if (c0 == 'E') {
            if (c1 == 'k') {
                return R.drawable.champ_ekko_square;
            } else if (c1 == 'l') {
                return R.drawable.champ_elise_square;
            } else if (c1 == 'v') {
                return R.drawable.champ_evelynn_square;
            } else if (c1 == 'z') {
                return R.drawable.champ_ezreal_square;
            }
            return R.drawable.champion_square;
        } else if (c0 == 'F') {
            if (c1 == 'i') {
                if (c2 == 'd') {
                    return R.drawable.champ_fiddlesticks_square;
                } else if (c2 == 'o') {
                    return R.drawable.champ_fiora_square;
                } else if (c2 == 'z') {
                    return R.drawable.champ_fizz_square;
                } else {
                    return R.drawable.champion_square;
                }
            }
            return R.drawable.champion_square;
        } else if (c0 == 'G') {
            if (c1 == 'a') {
                if (c2 == 'l') {
                    return R.drawable.champ_galio_square;
                } else if (c2 == 'n') {
                    return R.drawable.champ_gangplank_square;
                } else if (c2 == 'r') {
                    return R.drawable.champ_garen_square;
                } else {
                    return R.drawable.champion_square;
                }
            } else if (c1 == 'n') {
                return R.drawable.champ_gnar_square;
            } else if (c1 == 'r') {
                if (c2 == 'a') {
                    if (c3 == 'g') {
                        return R.drawable.champ_gragas_square;
                    } else if (c3 == 'v') {
                        return R.drawable.champ_graves_square;
                    } else {
                        return R.drawable.champion_square;
                    }
                } else {
                    return R.drawable.champion_square;
                }
            }
            return R.drawable.champion_square;
        } else if (c0 == 'H') {
            if (c1 == 'e') {
                if (c2 == 'c') {
                    return R.drawable.champ_hecarim_square;
                } else if (c2 == 'i') {
                    return R.drawable.champ_heimerdinger_square;
                } else {
                    return R.drawable.champion_square;
                }
            }
            return R.drawable.champion_square;
        } else if (c0 == 'I') {
            if (c1 == 'l') {
                return R.drawable.champ_illaoi_square;
            } else if (c1 == 'r') {
                return R.drawable.champ_irelia_square;
            }
            return R.drawable.champion_square;
        } else if (c0 == 'J') {
            if (c1 == 'a') {
                if (c2 == 'n') {
                    return R.drawable.champ_janna_square;
                } else if (c2 == 'r') {
                    return R.drawable.champ_jarvaniv_square;
                } else if (c2 == 'x') {
                    return R.drawable.champ_jax_square;
                } else if (c2 == 'y') {
                    return R.drawable.champ_jayce_square;
                } else {
                    return R.drawable.champion_square;
                }
            } else if (c1 == 'h') {
                return R.drawable.champ_jhin_square;
            } else if (c1 == 'i') {
                return R.drawable.champ_jinx_square;
            }
            return R.drawable.champion_square;
        } else if (c0 == 'K') {
            if (c1 == 'a') {
                if (c2 == 'l') {
                    return R.drawable.champ_kalista_square;
                } else if (c2 == 'r') {
                    if (c3 == 'm') {
                        return R.drawable.champ_karma_square;
                    } else if (c3 == 't') {
                        return R.drawable.champ_karthus_square;
                    } else {
                        return R.drawable.champion_square;
                    }
                } else if (c2 == 's') {
                    return R.drawable.champ_kassadin_square;
                } else if (c2 == 't') {
                    return R.drawable.champ_katarina_square;
                } else if (c2 == 'y') {
                    return R.drawable.champ_kayle_square;
                } else {
                    return R.drawable.champion_square;
                }
            } else if (c1 == 'e') {
                return R.drawable.champ_kennen_square;
            } else if (c1 == 'h') {
                return R.drawable.champ_khazix_square;
            } else if (c1 == 'i') {
                return R.drawable.champ_kindred_square;
            } else if (c1 == 'l') {
                return R.drawable.champ_kled_square;
            } else if (c1 == 'o') {
                return R.drawable.champ_kogmaw_square;
            }
            return R.drawable.champion_square;
        } else if (c0 == 'L') {
            if (c1 == 'e') {
                if (c2 == 'B') {
                    return R.drawable.champ_leblanc_square;
                } else if (c2 == 'e') {
                    return R.drawable.champ_leesin_square;
                } else if (c2 == 'o') {
                    return R.drawable.champ_leona_square;
                } else {
                    return R.drawable.champion_square;
                }
            } else if (c1 == 'i') {
                return R.drawable.champ_lissandra_square;
            } else if (c1 == 'u') {
                if (c2 == 'c') {
                    return R.drawable.champ_lucian_square;
                } else if (c2 == 'l') {
                    return R.drawable.champ_lulu_square;
                } else if (c2 == 'x') {
                    return R.drawable.champ_lux_square;
                } else {
                    return R.drawable.champion_square;
                }
            }
            return R.drawable.champion_square;
        } else if (c0 == 'M') {
            if (c1 == 'a') {
                if (c2 == 'l') {
                    if (c3 == 'p') {
                        return R.drawable.champ_malphite_square;
                    } else if (c3 == 'z') {
                        return R.drawable.champ_malzahar_square;
                    } else {
                        return R.drawable.champion_square;
                    }
                } else if (c2 == 'o') {
                    return R.drawable.champ_maokai_square;
                } else if (c2 == 's') {
                    return R.drawable.champ_masteryi_square;
                }
                else {
                    return R.drawable.champion_square;
                }
            } else if (c1 == 'i') {
                return R.drawable.champ_missfortune_square;
            } else if (c1 == 'o') {
                if (c2 == 'r') {
                    if (c3 == 'd') {
                        return R.drawable.champ_mordekaiser_square;
                    } else if (c3 == 'g') {
                        return R.drawable.champ_morgana_square;
                    } else {
                        return R.drawable.champion_square;
                    }
                } else {
                    return R.drawable.champion_square;
                }
            }
            return R.drawable.champion_square;
        } else if (c0 == 'N') {
            if (c1 == 'a') {
                if (c2 == 'm') {
                    return R.drawable.champ_nami_square;
                } else if (c2 == 's') {
                    return R.drawable.champ_nasus_square;
                } else if (c2 == 'u') {
                    return R.drawable.champ_nautilus_square;
                }
                else {
                    return R.drawable.champion_square;
                }
            } else if (c1 == 'i') {
                return R.drawable.champ_nidalee_square;
            } else if (c1 == 'o') {
                return R.drawable.champ_nocturne_square;
            } else if (c1 == 'u') {
                return R.drawable.champ_nunu_square;
            }
            return R.drawable.champion_square;
        } else if (c0 == 'O') {
            if (c1 == 'l') {
                return R.drawable.champ_olaf_square;
            } else if (c1 == 'r') {
                return R.drawable.champ_orianna_square;
            }
            return R.drawable.champion_square;
        } else if (c0 == 'P') {
            if (c1 == 'a') {
                return R.drawable.champ_pantheon_square;
            } else if (c1 == 'o') {
                return R.drawable.champ_poppy_square;
            }
            return R.drawable.champion_square;
        } else if (c0 == 'Q') {
            if (c1 == 'u') {
                return R.drawable.champ_quinn_square;
            }
            return R.drawable.champion_square;
        } else if (c0 == 'R') {
            if (c1 == 'a') {
                return R.drawable.champ_rammus_square;
            } else if (c1 == 'e') {
                if (c2 == 'k') {
                    return R.drawable.champ_reksai_square;
                } else if (c2 == 'n') {
                    if (c3 == 'e') {
                        return R.drawable.champ_renekton_square;
                    } else if (c3 == 'g') {
                        return R.drawable.champ_rengar_square;
                    } else {
                        return R.drawable.champion_square;
                    }
                } else {
                    return R.drawable.champion_square;
                }
            } else if (c1 == 'i') {
                return R.drawable.champ_riven_square;
            } else if (c1 == 'u') {
                return R.drawable.champ_rumble_square;
            } else if (c1 == 'y') {
                return R.drawable.champ_ryze_square;
            }
            return R.drawable.champion_square;
        } else if (c0 == 'S') {
            if (c1 == 'e') {
                return R.drawable.champ_sejuani_square;
            } else if (c1 == 'h') {
                if (c2 == 'a') {
                    return R.drawable.champ_shaco_square;
                } else if (c2 == 'e') {
                    return R.drawable.champ_shen_square;
                } else if (c2 == 'y') {
                    return R.drawable.champ_shyvana_square;
                } else {
                    return R.drawable.champion_square;
                }
            } else if (c1 == 'i') {
                if (c2 == 'n') {
                    return R.drawable.champ_singed_square;
                } else if (c2 == 'o') {
                    return R.drawable.champ_sion_square;
                } else if (c2 == 'v') {
                    return R.drawable.champ_sivir_square;
                } else {
                    return R.drawable.champion_square;
                }
            } else if (c1 == 'k') {
                return R.drawable.champ_skarner_square;
            } else if (c1 == 'o') {
                if (c2 == 'n') {
                    return R.drawable.champ_sona_square;
                } else if (c2 == 'r') {
                    return R.drawable.champ_soraka_square;
                } else {
                    return R.drawable.champion_square;
                }
            } else if (c1 == 'w') {
                return R.drawable.champ_swain_square;
            } else if (c1 == 'y') {
                return R.drawable.champ_syndra_square;
            }
            return R.drawable.champion_square;
        } else if (c0 == 'T') {
            if (c1 == 'a') {
                if (c2 == 'h') {
                    return R.drawable.champ_tahmkench_square;
                } else if (c2 == 'l') {
                    if (c3 == 'i') {
                        return R.drawable.champ_taliyah_square;
                    } else if (c3 == 'o') {
                        return R.drawable.champ_talon_square;
                    } else {
                        return R.drawable.champion_square;
                    }
                } else if (c2 == 'r') {
                    return R.drawable.champ_taric_square;
                } else {
                    return R.drawable.champion_square;
                }
            } else if (c1 == 'e') {
                return R.drawable.champ_teemo_square;
            } else if (c1 == 'h') {
                return R.drawable.champ_thresh_square;
            } else if (c1 == 'r') {
                if (c2 == 'i') {
                    return R.drawable.champ_tristana_square;
                } else if (c2 == 'u') {
                    return R.drawable.champ_trundle_square;
                } else if (c2 == 'y') {
                    return R.drawable.champ_tryndamere_square;
                }
                else {
                    return R.drawable.champion_square;
                }
            } else if (c1 == 'w') {
                if (c2 == 'i') {
                    if (c3 == 's') {
                        return R.drawable.champ_twistedfate_square;
                    } else if (c3 == 't') {
                        return R.drawable.champ_twitch_square;
                    } else {
                        return R.drawable.champion_square;
                    }
                } else {
                    return R.drawable.champion_square;
                }
            }
            return R.drawable.champion_square;
        } else if (c0 == 'U') {
            if (c1 == 'd') {
                return R.drawable.champ_udyr_square;
            } else if (c1 == 'r') {
                return R.drawable.champ_urgot_square;
            }
            return R.drawable.champion_square;
        } else if (c0 == 'V') {
            if (c1 == 'a') {
                if (c2 == 'r') {
                    return R.drawable.champ_varus_square;
                } else if (c2 == 'y') {
                    return R.drawable.champ_vayne_square;
                } else {
                    return R.drawable.champion_square;
                }
            } else if (c1 == 'e') {
                if (c2 == 'i') {
                    return R.drawable.champ_veigar_square;
                } else if (c2 == 'l') {
                    return R.drawable.champ_velkoz_square;
                } else {
                    return R.drawable.champion_square;
                }
            } else if (c1 == 'i') {
                if (champ.toLowerCase().equals("vi")) {
                    return R.drawable.champ_vi_square;
                } else if (c2 == 'k') {
                    return R.drawable.champ_viktor_square;
                }
            } else if (c1 == 'l') {
                return R.drawable.champ_vladimir_square;
            } else if (c1 == 'o') {
                return R.drawable.champ_volibear_square;
            }
            return R.drawable.champion_square;
        } else if (c0 == 'W') {
            if (c1 == 'a') {
                return R.drawable.champ_warwick_square;
            } else if (c1 == 'u') {
                return R.drawable.champ_wukong_square;
            }
            return R.drawable.champion_square;
        } else if (c0 == 'X') {
            if (c1 == 'e') {
                return R.drawable.champ_xerath_square;
            } else if (c1 == 'i') {
                return R.drawable.champ_xinzhao_square;
            }
            return R.drawable.champion_square;
        } else if (c0 == 'Y') {
            if (c1 == 'a') {
                return R.drawable.champ_yasuo_square;
            } else if (c1 == 'o') {
                return R.drawable.champ_yorick_square;
            }
            return R.drawable.champion_square;
        } else if (c0 == 'Z') {
            if (c1 == 'a') {
                return R.drawable.champ_zac_square;
            } else if (c1 == 'e') {
                return R.drawable.champ_zed_square;
            } else if (c1 == 'i') {
                if (c2 == 'g') {
                    return R.drawable.champ_ziggs_square;
                } else if (c2 == 'l') {
                    return R.drawable.champ_zilean_square;
                } else {
                    return R.drawable.champion_square;
                }
            } else if (c1 == 'y') {
                return R.drawable.champ_zyra_square;
            }
            return R.drawable.champion_square;
        }
        return R.drawable.champion_square;
    }

    public static ChampSkill getChampSkill(Context context, String champName) {
        ChampSkill tmpChampSkill = new ChampSkill(champName);
        if (champName.equals("noChamp")) {
            return tmpChampSkill;
        }
        DataBaseHelper dbHelper = new DataBaseHelper(context, "lolchampskill.db");

        try {
            dbHelper.createDataBase();
        } catch (IOException e) {
            throw new Error("Unable to create db");
        }

        try {
            dbHelper.openDataBase();
        } catch (SQLException e) {
            throw new Error("Unable to open db");
        }

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "SELECT pname, p, qname, q, wname, w, ename, e, rname, r FROM LOLCHAMPSKILL WHERE champ = \"" + champName + "\"";
        Cursor cursor = db.rawQuery(sql, new String[]{});

        if (cursor.moveToFirst()) {
            tmpChampSkill.setPname(cursor.getString(0));
            tmpChampSkill.setP(cursor.getString(1));
            tmpChampSkill.setQname(cursor.getString(2));
            tmpChampSkill.setQ(cursor.getString(3));
            tmpChampSkill.setWname(cursor.getString(4));
            tmpChampSkill.setW(cursor.getString(5));
            tmpChampSkill.setEname(cursor.getString(6));
            tmpChampSkill.setE(cursor.getString(7));
            tmpChampSkill.setRname(cursor.getString(8));
            tmpChampSkill.setR(cursor.getString(9));
        }
        cursor.close();
        db.close();
        dbHelper.close();

        return tmpChampSkill;
    }

    public static String getNewLine(String origional){
        String tmpstr = "";
        int i = 0;
        if (!origional.contains("\\n")) {
            return origional;
        }
        while (origional.contains("\\n")) {
            i = origional.indexOf("\\n");
            tmpstr += origional.substring(0, i);
            tmpstr += "\n";
            origional = origional.substring(i+2);
        }
        return tmpstr;
    }
}
