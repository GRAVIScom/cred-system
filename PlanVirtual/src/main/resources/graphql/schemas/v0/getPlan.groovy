package graphql.schemas.v0

import gql.DSL
import graphql.schema.DataFetchingEnvironment
import org.slf4j.LoggerFactory

logger = LoggerFactory.getLogger(getClass().getName())

def resultPlan = DSL.type('resultPlan'){
    field 'debtCode', GraphQLString
    field 'summa', GraphQLInt
    field 'date', GraphQLString
}

schema = DSL.schema {
    queries {
        field('getPlan') {
            description('Получить график платежей')
            type resultPlan
            argument('loanId', GraphQLInt)
            fetcher {
                DataFetchingEnvironment env ->
                    try{
                        def loanId = env.arguments.loanId
                    }catch (Exception e){
                        def message = "Произошла ошибка при расчете плана"
                        logger.error(message, e)
                    }
            }
        }
    }
}