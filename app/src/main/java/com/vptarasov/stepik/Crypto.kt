package com.vptarasov.stepik

class Crypto {

    fun getCryptoCode(str: String): String {
        var cryptoString = ""
        val charArray = str.toCharArray()
        var strBuff = ""
        var count = 0
        for (i in charArray.indices) {


            if (strBuff == "") {
                strBuff = charArray[i].toString()
                count++
            } else if (charArray[i].toString() == strBuff) {
                count++
            } else {
                cryptoString = cryptoString + strBuff + count
                strBuff = charArray[i].toString()
                count = 1
            }

        }
        cryptoString = cryptoString + strBuff + count

        return cryptoString
    }


}