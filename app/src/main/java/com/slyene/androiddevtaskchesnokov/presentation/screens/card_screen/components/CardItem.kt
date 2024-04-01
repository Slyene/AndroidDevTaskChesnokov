package com.slyene.androiddevtaskchesnokov.presentation.screens.card_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.slyene.androiddevtaskchesnokov.R
import com.slyene.androiddevtaskchesnokov.domain.model.Company
import com.slyene.androiddevtaskchesnokov.presentation.components.AndroidDevTaskChesnokovText
import com.slyene.androiddevtaskchesnokov.presentation.ui.theme.AndroidDevTaskChesnokovTheme
import com.slyene.androiddevtaskchesnokov.presentation.util.parseColor

@Composable
fun CardItem(
    company: Company,
    modifier: Modifier = Modifier,
    onButtonClick: (String, String) -> Unit
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp)),
        colors = CardColors(
            containerColor = parseColor(company.cardBackgroundColor),
            contentColor = parseColor(company.highlightTextColor),
            disabledContainerColor = parseColor(company.cardBackgroundColor),
            disabledContentColor = parseColor(company.highlightTextColor)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.margin1))
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                AndroidDevTaskChesnokovText(
                    text = company.companyName,
                    color = parseColor(company.highlightTextColor),
                    fontSize = dimensionResource(id = R.dimen.text1).value.sp
                )

                Spacer(modifier = Modifier.weight(1f))

                AsyncImage(
                    model = company.logo,
                    contentDescription = company.companyName,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.logoSize))
                        .clip(CircleShape)
                )
            }

            HorizontalDivider(
                modifier = Modifier
                    .padding(
                        top = dimensionResource(id = R.dimen.margin2),
                        bottom = dimensionResource(id = R.dimen.margin1)
                    ),
                color = parseColor(company.backgroundColor)
            )

            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                AndroidDevTaskChesnokovText(
                    text = company.mark.toString(),
                    fontWeight = FontWeight.Bold,
                    fontSize = dimensionResource(id = R.dimen.text0).value.sp,
                    color = parseColor(company.highlightTextColor)
                )

                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.margin2)))

                AndroidDevTaskChesnokovText(
                    text = when (company.mark % 10) {
                        1 -> stringResource(id = R.string.point)
                        in 2..4 -> stringResource(id = R.string.points1)
                        else -> stringResource(id = R.string.points2)
                    },
                    color = parseColor(company.textColor),
                    fontSize = dimensionResource(id = R.dimen.text2).value.sp
                )
            }

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin1)))

            Row {
                Column {
                    AndroidDevTaskChesnokovText(
                        text = stringResource(id = R.string.cashback),
                        color = parseColor(company.textColor),
                        fontSize = dimensionResource(id = R.dimen.text4).value.sp
                    )


                    AndroidDevTaskChesnokovText(
                        text = "${company.cashToMark} %",
                        color = parseColor(company.highlightTextColor),
                        fontSize = dimensionResource(id = R.dimen.text3).value.sp
                    )
                }

                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.margin3)))

                Column {
                    AndroidDevTaskChesnokovText(
                        text = stringResource(id = R.string.level),
                        color = parseColor(company.textColor),
                        fontSize = dimensionResource(id = R.dimen.text4).value.sp
                    )


                    AndroidDevTaskChesnokovText(
                        text = company.name,
                        color = parseColor(company.highlightTextColor),
                        fontSize = dimensionResource(id = R.dimen.text3).value.sp
                    )
                }
            }

            HorizontalDivider(
                modifier = Modifier
                    .padding(
                        top = dimensionResource(id = R.dimen.margin2),
                        bottom = 5.dp
                    ),
                color = parseColor(company.backgroundColor)
            )

            Row(
                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.margin1)),
            ) {
                val showButton = stringResource(id = R.string.show_button)
                val deleteButton = stringResource(id = R.string.delete_button)
                val detailsButton = stringResource(id = R.string.details_button)

                Row(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.margin1))) {
                    IconButton(
                        onClick = {
                            onButtonClick(
                                showButton,
                                company.companyId
                            )
                        },
                        modifier = Modifier.size(dimensionResource(id = R.dimen.iconSize))
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_eye),
                            contentDescription = stringResource(id = R.string.show_button),
                            tint = parseColor(company.mainColor)
                        )
                    }

                    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.margin3)))

                    IconButton(
                        onClick = {
                            onButtonClick(
                                deleteButton,
                                company.companyId
                            )
                        },
                        modifier = Modifier.size(dimensionResource(id = R.dimen.iconSize))
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_trash),
                            contentDescription = stringResource(id = R.string.show_button),
                            tint = parseColor(company.accentColor)
                        )
                    }
                }

                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.margin3)))

                Button(
                    onClick = {
                        onButtonClick(
                            detailsButton,
                            company.companyId
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonColors(
                        containerColor = parseColor(company.backgroundColor),
                        contentColor = parseColor(company.mainColor),
                        disabledContainerColor = parseColor(company.backgroundColor),
                        disabledContentColor = parseColor(company.mainColor),
                    )
                ) {
                    AndroidDevTaskChesnokovText(
                        text = stringResource(id = R.string.details),
                        color = parseColor(company.mainColor),
                        fontSize = dimensionResource(id = R.dimen.text2).value.sp
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = false)
fun CardItemPreview() {
    AndroidDevTaskChesnokovTheme {
        CardItem(company = Company(
            companyId = "40858d29-1319-4cb4-86ec-6560cd4baa4b",
            cashToMark = 35,
            markToCash = 99,
            name = "золотой",
            number = 8,
            requiredSum = 19959,
            mark = 7619,
            companyName = "У тебя может получиться!",
            logo = "http://bonusmoney.info/image/mail/logo3.png",
            backgroundColor = "#EFEFEF",
            mainColor = "#2688EB",
            cardBackgroundColor = "#FFFFFF",
            textColor = "#949494",
            highlightTextColor = "#1A1A1A",
            accentColor = "#FF3044"
        ),
            onButtonClick = { _, _ -> }
        )
    }
}