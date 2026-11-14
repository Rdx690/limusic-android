package com.simohypers.limusic.lyrics.romanization

/**
 * Bangla script → simple Latin reading for singing along.
 *
 * This intentionally uses familiar, no-diacritic spellings: ভালো becomes "bhalo" and
 * তুমি becomes "tumi", rather than academic transliteration with special marks.
 */
internal object BengaliRomanizer {
    private const val VIRAMA = '্'

    private val CONSONANTS = mapOf(
        'ক' to "k", 'খ' to "kh", 'গ' to "g", 'ঘ' to "gh", 'ঙ' to "ng",
        'চ' to "ch", 'ছ' to "chh", 'জ' to "j", 'ঝ' to "jh", 'ঞ' to "n",
        'ট' to "t", 'ঠ' to "th", 'ড' to "d", 'ঢ' to "dh", 'ণ' to "n",
        'ত' to "t", 'থ' to "th", 'দ' to "d", 'ধ' to "dh", 'ন' to "n",
        'প' to "p", 'ফ' to "ph", 'ব' to "b", 'ভ' to "bh", 'ম' to "m",
        'য' to "j", 'র' to "r", 'ল' to "l", 'শ' to "sh", 'ষ' to "sh",
        'স' to "s", 'হ' to "h", 'ড়' to "r", 'ঢ়' to "rh", 'য়' to "y",
    )

    private val VOWELS = mapOf(
        'অ' to "a", 'আ' to "aa", 'ই' to "i", 'ঈ' to "i", 'উ' to "u",
        'ঊ' to "u", 'ঋ' to "ri", 'এ' to "e", 'ঐ' to "oi", 'ও' to "o", 'ঔ' to "ou",
    )

    private val MATRAS = mapOf(
        'া' to "aa", 'ি' to "i", 'ী' to "i", 'ু' to "u", 'ূ' to "u",
        'ৃ' to "ri", 'ে' to "e", 'ৈ' to "oi", 'ো' to "o", 'ৌ' to "ou",
    )

    private val SIGNS = mapOf('ং' to "ng", 'ঁ' to "n", 'ঃ' to "h")

    fun romanize(line: String): String {
        val out = StringBuilder()
        var index = 0
        while (index < line.length) {
            val char = line[index]
            val consonant = CONSONANTS[char]
            if (consonant != null) {
                out.append(consonant)
                val next = line.getOrNull(index + 1)
                when {
                    next == VIRAMA -> index++
                    next != null && MATRAS.containsKey(next) -> {
                        out.append(MATRAS.getValue(next))
                        index++
                    }
                    else -> out.append("o")
                }
                index++
                continue
            }
            VOWELS[char]?.let { out.append(it); index++; continue }
            SIGNS[char]?.let { out.append(it); index++; continue }
            out.append(char)
            index++
        }
        return out.toString()
    }
}
