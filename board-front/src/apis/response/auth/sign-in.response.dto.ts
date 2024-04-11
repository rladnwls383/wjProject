import ResponseDto from "../response.dto";

export default interface SignInResponseDto extends ResponseDto {
    token: String;
    exprirationTime: number;
}